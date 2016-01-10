package br.com.erick.desafioalgaworks4.matricula.controller;

import java.io.Serializable;

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
public class CadastroDisciplinaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private DisciplinaService disciplinaService;
	
	private Disciplina disciplina;
	
	@PostConstruct
	public void init(){
		this.limpar();
	}
	
	public void salvar(){
		try {
			this.disciplinaService.salvar(this.disciplina);
			FacesUtil
				.addSuccessMessage("Disciplina "
						+this.disciplina.getNome()
						+" salva com sucesso!");
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil
			 	.addErrorMessage("Falha ao criar o disciplina: " 
			 			+ e.getMessage());
		}
	}
	
	private void limpar(){
		this.disciplina = new Disciplina();
	}

	/**
	 * @return the disciplina
	 */
	public Disciplina getDisciplina() {
		return disciplina;
	}
	/**
	 * @param disciplina the disciplina to set
	 */
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
