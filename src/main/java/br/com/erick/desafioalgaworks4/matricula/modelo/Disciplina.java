package br.com.erick.desafioalgaworks4.matricula.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String nome;
	
	@ManyToMany(mappedBy = "disciplinas", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Professor> professores;
	
	@ManyToMany(mappedBy = "professores", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Turma> turmas;
	
	@Transient
	private Professor professorDaDisciplina;

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the professores
	 */
	public List<Professor> getProfessores() {
		if(professores == null){
			professores = new ArrayList<Professor>();
		}
		return professores;
	}
	/**
	 * @param professores the professores to set
	 */
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	/**
	 * @return the turmas
	 */
	public List<Turma> getTurmas() {
		if(turmas == null){
			turmas = new ArrayList<Turma>();
		}
		return turmas;
	}
	/**
	 * @param turmas the turmas to set
	 */
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	/**
	 * @return the professorDaDisciplina
	 */
	public Professor getProfessorDaDisciplina() {
		return professorDaDisciplina;
	}
	/**
	 * @param professorDaDisciplina the professorDaDisciplina to set
	 */
	public void setProfessorDaDisciplina(Professor professorDaDisciplina) {
		this.professorDaDisciplina = professorDaDisciplina;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Disciplina [codigo=" + codigo + ", nome=" + nome + "]";
	}
}
