package br.com.erick.desafioalgaworks4.matricula.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.erick.desafioalgaworks4.matricula.modelo.Disciplina;
import br.com.erick.desafioalgaworks4.matricula.service.DisciplinaService;
import br.com.erick.desafioalgaworks4.matricula.service.NegocioException;
import br.com.erick.desafioalgaworks4.matricula.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaDisciplinaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private DisciplinaService disciplinaService;
	
	private List<Disciplina> disciplinas;
	
	private Disciplina disciplinaSelecionada;
	
	@PostConstruct
	public void init(){
		try {
			this.disciplinas = this.disciplinaService.listarTodos();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Falha ao listar disciplinas: " 
					+ e.getMessage());
		}
	}
	
	public void excluir(){
		try {
			this.disciplinaService.excluir(this.disciplinaSelecionada);
			
			this.disciplinas.remove(this.disciplinaSelecionada);
			
			FacesUtil.addSuccessMessage(
					"Disciplina " + this.disciplinaSelecionada.getNome() + 
					" excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	/**
	 * @return the disciplinas
	 */
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	/**
	 * @param disciplinas the disciplinas to set
	 */
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	/**
	 * @return the disciplinaSelecionada
	 */
	public Disciplina getDisciplinaSelecionada() {
		return disciplinaSelecionada;
	}
	/**
	 * @param disciplinaSelecionada the disciplinaSelecionada to set
	 */
	public void setDisciplinaSelecionada(Disciplina disciplinaSelecionada) {
		this.disciplinaSelecionada = disciplinaSelecionada;
	}
}
