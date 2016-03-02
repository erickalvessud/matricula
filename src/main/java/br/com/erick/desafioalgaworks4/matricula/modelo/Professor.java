package br.com.erick.desafioalgaworks4.matricula.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "registro")
	private Long codigo;
	
	private String nome;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "professor_disciplina", 
		joinColumns = {@JoinColumn(name = "registro_professor", referencedColumnName = "registro", nullable = false)},
		inverseJoinColumns = { @JoinColumn(name = "codigo_disciplina", referencedColumnName = "codigo", nullable = false)}
	)
	private List<Disciplina> disciplinas;
	
	@ManyToMany(mappedBy = "professores", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Turma> turmas;

	/**
	 * Construtor 
	 */
	public Professor() {

	}
	
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
	 * @return the disciplinas
	 */
	public List<Disciplina> getDisciplinas() {
		if(disciplinas == null){
			disciplinas = new ArrayList<Disciplina>();
		}
		return disciplinas;
	}
	/**
	 * @param disciplinas the disciplinas to set
	 */
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
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
		Professor other = (Professor) obj;
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
		return "Professor [codigo=" + codigo + ", nome=" + nome + "]";
	}
}
