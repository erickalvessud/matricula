package br.com.erick.desafioalgaworks4.matricula.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.erick.desafioalgaworks4.matricula.modelo.Disciplina;
import br.com.erick.desafioalgaworks4.matricula.modelo.Professor;
import br.com.erick.desafioalgaworks4.matricula.service.DisciplinaService;
import br.com.erick.desafioalgaworks4.matricula.service.NegocioException;
import br.com.erick.desafioalgaworks4.matricula.service.ProfessorService;
import br.com.erick.desafioalgaworks4.matricula.util.jsf.FacesUtil;

/**
 * Controller para a tela de cadastro de professores 
 * @author Erick Alves
 *
 */
@Named
@ViewScoped
public class CadastroProfessorBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ProfessorService professorService;
	
	@Inject
	private DisciplinaService disciplinaService;
	
	private Professor professor;
	
	private List<Disciplina> disciplinas;
	
	@PostConstruct
	public void init(){
		this.limpar();
	}
	
	/**
	 * Salva ou atualiza o professor e suas disciplinas 
	 */
	public void salvar(){
		try {
			
			for ( Disciplina disciplina : this.professor.getDisciplinas()) {
				ArrayList<Professor> professores = new ArrayList<>();
				professores.add(this.professor);
				disciplina.setProfessores(professores);
			}
			
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
	
	/**
	 * Lista todas as disciplinas cadastradas para serem escolhidas e vinculadas
	 * a um professor.
	 */
	public void carregarDisciplinas(){
		try {
			
			this.disciplinas = this.disciplinaService.listarTodos();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Falha ao listar disciplinas: " 
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

}
