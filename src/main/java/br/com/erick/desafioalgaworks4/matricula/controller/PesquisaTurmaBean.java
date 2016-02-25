package br.com.erick.desafioalgaworks4.matricula.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.erick.desafioalgaworks4.matricula.modelo.Turma;
import br.com.erick.desafioalgaworks4.matricula.service.NegocioException;
import br.com.erick.desafioalgaworks4.matricula.service.TurmaService;
import br.com.erick.desafioalgaworks4.matricula.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaTurmaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TurmaService turmaService;
	
	private List<Turma> turmas;
	
	private Turma turmaSelecionada;
	
	@PostConstruct
	public void init(){
		try {
			this.turmas = this.turmaService.listarTodos();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Falha ao listar turmas: " 
					+ e.getMessage());
		}
	}
	
	public void excluir(){
		try {
			this.turmaService.excluir(this.turmaSelecionada);
			
			this.turmas.remove(this.turmaSelecionada);
			
			FacesUtil.addSuccessMessage(
					"Turma " + this.turmaSelecionada.getNome() + 
					" excluída com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	/**
	 * @return the turmas
	 */
	public List<Turma> getTurmas() {
		return turmas;
	}

	/**
	 * @param turmas the turmas to set
	 */
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	/**
	 * @return the turmaSelecionada
	 */
	public Turma getTurmaSelecionada() {
		return turmaSelecionada;
	}

	/**
	 * @param turmaSelecionada the turmaSelecionada to set
	 */
	public void setTurmaSelecionada(Turma turmaSelecionada) {
		this.turmaSelecionada = turmaSelecionada;
	}
}
