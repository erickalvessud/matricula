package br.com.erick.desafioalgaworks4.matricula.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String nome;
	
	@ManyToMany(mappedBy = "disciplinas")
	private List<Professor> professores;
	
	@ManyToMany
	@JoinTable(name = "disciplina_turma", 
		joinColumns = { @JoinColumn(name = "codigo_disciplina", nullable = false) },
		inverseJoinColumns = { @JoinColumn(name = "codigo_turma", nullable = false) }
	)
	private List<Turma> turmas;

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
		return turmas;
	}
	/**
	 * @param turmas the turmas to set
	 */
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
