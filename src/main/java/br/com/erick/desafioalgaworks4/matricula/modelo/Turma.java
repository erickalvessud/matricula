package br.com.erick.desafioalgaworks4.matricula.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String nome;
	
	@OneToMany(mappedBy = "turma")
	private List<Matricula> matriculas;
	
	@ManyToMany(mappedBy = "turmas")
	private List<Disciplina> disciplinas;
	
	@ManyToMany(mappedBy = "turmas")
	private List<Professor> professores;
	
	public Turma() {

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
	 * @return the matriculas
	 */
	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	/**
	 * @param matriculas the matriculas to set
	 */
	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
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
}
