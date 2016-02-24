package br.com.erick.desafioalgaworks4.matricula.modelo;

import java.io.Serializable;
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "professor_disciplina", 
		joinColumns = {@JoinColumn(name = "registro_professor", nullable = false)},
		inverseJoinColumns = { @JoinColumn(name = "codigo_disciplina", nullable = false)}
	)
	private List<Disciplina> disciplinas;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "professor_turma",
		joinColumns = { @JoinColumn(name = "registro_professor", nullable = false)},
		inverseJoinColumns = { @JoinColumn(name = "codigo_turma", nullable = false)}
	)
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
		return turmas;
	}
	/**
	 * @param turmas the turmas to set
	 */
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Professor [codigo=" + codigo + ", nome=" + nome + "]";
	}
}
