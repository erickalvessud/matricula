package br.com.erick.desafioalgaworks4.matricula.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProfessorTurma
 *
 */
@Entity
@Table(name = "professor_turma_disciplina")
public class ProfessorTurmaDisciplina implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProfessorTurmaDisciplinaPK professorTurmaDisciplinaPK;

	@ManyToOne
	@JoinColumn(name = "registro_professor", referencedColumnName = "registro", nullable = true, updatable = false, insertable = false)
	private Professor professor;
	
	@ManyToOne
	@JoinColumn(name = "codigo_turma", referencedColumnName = "codigo", nullable = true, updatable = false, insertable = false)
	private Turma turma;
	
	@ManyToOne
	@JoinColumn(name = "codigo_disciplina", referencedColumnName = "codigo", nullable = true, updatable = false, insertable = false)
	private Disciplina disciplina;

	public ProfessorTurmaDisciplina() {
		super();
	}

	public ProfessorTurmaDisciplinaPK getProfessorTurmaDisciplinaPK() {
		return professorTurmaDisciplinaPK;
	}
	public void setProfessorTurmaDisciplinaPK(ProfessorTurmaDisciplinaPK professorTurmaDisciplinaPK) {
		this.professorTurmaDisciplinaPK = professorTurmaDisciplinaPK;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
   
	
}
