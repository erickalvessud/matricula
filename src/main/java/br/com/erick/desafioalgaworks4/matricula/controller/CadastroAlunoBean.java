package br.com.erick.desafioalgaworks4.matricula.controller;

import java.io.Serializable;

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
public class CadastroAlunoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoService alunoService;
	
	private Aluno aluno;

	@PostConstruct
	public void init(){
		this.limpar();
	}
	
	public void salvar(){
		try {
			this.alunoService.salvar(this.aluno);
			this.limpar();
			FacesUtil.addSuccessMessage("Aluno salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Falha ao criar o aluno: " + e.getMessage());
		}
	}

	/**
	 * Método que limpa a tela do formulário.
	 */
	private void limpar() {
		this.aluno = new Aluno();
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
