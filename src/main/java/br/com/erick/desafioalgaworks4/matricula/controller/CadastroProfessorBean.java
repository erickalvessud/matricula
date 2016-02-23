package br.com.erick.desafioalgaworks4.matricula.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.erick.desafioalgaworks4.matricula.modelo.Professor;
import br.com.erick.desafioalgaworks4.matricula.service.NegocioException;
import br.com.erick.desafioalgaworks4.matricula.service.ProfessorService;
import br.com.erick.desafioalgaworks4.matricula.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProfessorBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ProfessorService professorService;
	
	private Professor professor;
	
	@PostConstruct
	public void init(){
		this.limpar();
	}
	
	public void salvar(){
		try {
			this.professorService.salvar(this.professor);
			FacesUtil
				.addSuccessMessage("Professor "
						+this.professor.getNome()
						+" salvo com sucesso!");
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil
			 	.addErrorMessage("Falha ao cadastrar o Professor: " 
			 			+ e.getMessage());
		}
	}
	
	private void limpar(){
		this.professor = new Professor();
	}

	/**
	 * @return the professor
	 */
	public Professor getProfessor() {
		return professor;
	}

	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
