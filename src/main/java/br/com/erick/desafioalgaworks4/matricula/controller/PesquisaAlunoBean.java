package br.com.erick.desafioalgaworks4.matricula.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.erick.desafioalgaworks4.matricula.modelo.Aluno;
import br.com.erick.desafioalgaworks4.matricula.service.AlunoService;
import br.com.erick.desafioalgaworks4.matricula.service.NegocioException;
import br.com.erick.desafioalgaworks4.matricula.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAlunoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoService alunoService;
	
	private List<Aluno> alunos;
	
	private Aluno alunoSelecionado;

	@PostConstruct
	public void init(){
		try {
			this.alunos = this.alunoService.listarTodos();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Falha ao listar aluno: " 
													+ e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			this.alunoService.excluir(this.alunoSelecionado);
			this.alunos.remove(this.alunoSelecionado);
			FacesUtil.addSuccessMessage(
					"Aluno " + this.alunoSelecionado.getNome() + 
					" excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}
	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}
}
