package br.com.erick.desafioalgaworks4.matricula.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProfessorTurmaPK
 *
 */
@Embeddable
public class ProfessorTurmaDisciplinaPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "registro_professor", nullable = false)
	private Long codigoProfessor;
	
	@Column(name = "codigo_turma", nullable = false)
	private Long codigoTurma;
	
	@Column(name = "codigo_disciplina")
	private Long codigoDisciplina;
	

	public ProfessorTurmaDisciplinaPK() {
		super();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDisciplina == null) ? 0 : codigoDisciplina.hashCode());
		result = prime * result + ((codigoProfessor == null) ? 0 : codigoProfessor.hashCode());
		result = prime * result + ((codigoTurma == null) ? 0 : codigoTurma.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessorTurmaDisciplinaPK other = (ProfessorTurmaDisciplinaPK) obj;
		if (codigoDisciplina == null) {
			if (other.codigoDisciplina != null)
				return false;
		} else if (!codigoDisciplina.equals(other.codigoDisciplina))
			return false;
		if (codigoProfessor == null) {
			if (other.codigoProfessor != null)
				return false;
		} else if (!codigoProfessor.equals(other.codigoProfessor))
			return false;
		if (codigoTurma == null) {
			if (other.codigoTurma != null)
				return false;
		} else if (!codigoTurma.equals(other.codigoTurma))
			return false;
		return true;
	}
}
