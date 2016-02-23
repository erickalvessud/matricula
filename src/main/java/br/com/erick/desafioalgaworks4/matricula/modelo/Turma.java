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
	
	@OneToMany(mappedBy = "turma")
	private List<ProfessorTurmaDisciplina> professorTurmaDisciplina;
	
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

	public List<ProfessorTurmaDisciplina> getProfessorTurmaDisciplina() {
		return professorTurmaDisciplina;
	}

	public void setProfessorTurmaDisciplina(List<ProfessorTurmaDisciplina> professorTurmaDisciplina) {
		this.professorTurmaDisciplina = professorTurmaDisciplina;
	}
}
