package br.com.erick.desafioalgaworks4.matricula.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.erick.desafioalgaworks4.matricula.modelo.Disciplina;
import br.com.erick.desafioalgaworks4.matricula.modelo.Professor;
import br.com.erick.desafioalgaworks4.matricula.modelo.Turma;
import br.com.erick.desafioalgaworks4.matricula.service.DisciplinaService;
import br.com.erick.desafioalgaworks4.matricula.service.NegocioException;
import br.com.erick.desafioalgaworks4.matricula.service.ProfessorService;
import br.com.erick.desafioalgaworks4.matricula.service.TurmaService;
import br.com.erick.desafioalgaworks4.matricula.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroTurmaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private TurmaService turmaService;
	
	@Inject
	private DisciplinaService disciplinaService;
	
	@Inject
	private ProfessorService professorService;
	
	private List<Disciplina> disciplinas;
	
	private Disciplina disciplinaSelecionada;
	
	private Professor professorSelecionado;
	
	/**
	 * Combos de disciplinas e professores
	 */
	private List<SelectItem> disciplinasSelectItem;
	
	private List<SelectItem> professoresSelectItem;
	
	private Turma turma;
	
	@PostConstruct
	public void init(){
		this.limpar();
		this.disciplinasSelectItem = new ArrayList<>();
		this.professoresSelectItem = new ArrayList<>();
	}

	public void salvar(){
		try {
			this.turmaService.salvar(this.turma);
			
			FacesUtil
				.addSuccessMessage("Turma " 
						+ this.turma.getNome() 
						+ " salva com sucesso!");
			
			this.limpar();

		} catch (NegocioException e) {
			FacesUtil
		 		.addErrorMessage("Falha ao cadastrar a turma: " 
		 				+ e.getMessage());
		}
	}
	
	public void carregarDisciplinas(){
		try {
			this.disciplinas = this.disciplinaService.listarTodos();
			
			this.carregarComboDisciplinas(this.disciplinas);
			
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Falha ao listar disciplinas: " 
					+ e.getMessage());
		}
	}
	
	private void carregarComboDisciplinas(List<Disciplina> disciplinas) {
		if (disciplinas != null && !disciplinas.isEmpty()) {

			this.disciplinasSelectItem.clear();

			for (Disciplina disciplina : disciplinas) {
				SelectItem disciplinaItem = new SelectItem();
				disciplinaItem.setLabel(disciplina.getCodigo() + " - " + disciplina.getNome());
				disciplinaItem.setValue(disciplina);

				this.disciplinasSelectItem.add(disciplinaItem);
			}
		}
	}
	
	public void carregarProfessoresPelaDisciplina() {
		if (this.disciplinaSelecionada != null) {

			try {
				List<Professor> professores = this.professorService
						.buscarProfessoresPelaDisciplina(this.disciplinaSelecionada);

				this.carregarComboProfessores(professores);

			} catch (NegocioException e) {
				FacesUtil.addErrorMessage("Falha ao buscar professores da disciplina "
						+ this.disciplinaSelecionada.getNome() + ": " + e.getMessage());
			}
		}
	}
	
	private void carregarComboProfessores(List<Professor> professores){
		if (professores != null && !professores.isEmpty()) {
			
			this.professoresSelectItem.clear();
			
			for (Professor professor : professores) {
				SelectItem professorItem = new SelectItem();
				professorItem.setLabel(professor.getCodigo() + " - " + professor.getNome());
				professorItem.setValue(professor);
				
				this.professoresSelectItem.add(professorItem);
			}
		}
	}
	
	public void adicionaProfessorTurmaDisciplina() {

//		if (this.turma.getProfessores().contains(this.professorSelecionado)
//				&& this.turma.getDisciplinas().contains(this.disciplinaSelecionada)) {
//			FacesUtil.addWarnMessage(
//					"A Disciplina " + this.disciplinaSelecionada.getNome() + " ministrada pelo professor(a) "
//							+ this.professorSelecionado.getNome() + " já foi adicionada a lista");
//			return;
//		}
//		
		this.disciplinaSelecionada.setProfessorDaDisciplina(this.professorSelecionado);
		
		this.disciplinaSelecionada.getTurmas().add(this.turma);
		this.professorSelecionado.getTurmas().add(this.turma);
		
		this.turma.getProfessores().put( this.disciplinaSelecionada, this.professorSelecionado);
	}
	
	public void limpar(){
		this.turma = new Turma();
	}
	
	/**
	 * @return the turma
	 */
	public Turma getTurma() {
		return turma;
	}

	/**
	 * @param turma the turma to set
	 */
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	/**
	 * @return the disciplinas
	 */
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
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
	/**
	 * @return the disciplinasSelectItem
	 */
	public List<SelectItem> getDisciplinasSelectItem() {
		return disciplinasSelectItem;
	}
	/**
	 * @param disciplinasSelectItem the disciplinasSelectItem to set
	 */
	public void setDisciplinasSelectItem(List<SelectItem> disciplinasSelectItem) {
		this.disciplinasSelectItem = disciplinasSelectItem;
	}

	/**
	 * @return the professoresSelectItem
	 */
	public List<SelectItem> getProfessoresSelectItem() {
		return professoresSelectItem;
	}
	/**
	 * @param professoresSelectItem the professoresSelectItem to set
	 */
	public void setProfessoresSelectItem(List<SelectItem> professoresSelectItem) {
		this.professoresSelectItem = professoresSelectItem;
	}

	/**
	 * @return the professorSelecionado
	 */
	public Professor getProfessorSelecionado() {
		return professorSelecionado;
	}

	/**
	 * @param professorSelecionado the professorSelecionado to set
	 */
	public void setProfessorSelecionado(Professor professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}
}
