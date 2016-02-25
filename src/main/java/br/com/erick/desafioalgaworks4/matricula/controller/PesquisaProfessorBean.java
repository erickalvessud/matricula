package br.com.erick.desafioalgaworks4.matricula.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class PesquisaProfessorBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProfessorService professorService;
	
	private List<Professor> professores;
	
	private Professor professorSelecionado;
	
	@PostConstruct
	public void init(){
		try {
			this.professores = this.professorService.listarTodos();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Falha ao listar professores: " 
					+ e.getMessage());
		}
	}
	
	public void buscarProfessorComDisciplinas(){
		try {
			this.professorSelecionado = this.professorService
					.buscarProfessorComDisciplinas(this.professorSelecionado.getCodigo());
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Listar professores com disciplinas: " 
					+ e.getMessage());
			this.professorSelecionado.setDisciplinas(new ArrayList<>());
		}
	}
	
	public void excluir(){
		try {
			this.professorService.excluir(this.professorSelecionado);
			
			this.professores.remove(this.professorSelecionado);
			
			FacesUtil.addSuccessMessage(
					"Professor " + this.professorSelecionado.getNome() + 
					" excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public Professor getProfessorSelecionado() {
		return professorSelecionado;
	}

	public void setProfessorSelecionado(Professor professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
}
