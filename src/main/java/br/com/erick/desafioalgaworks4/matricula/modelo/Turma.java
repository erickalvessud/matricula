package br.com.erick.desafioalgaworks4.matricula.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
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
	
	@OneToMany(mappedBy = "turma", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Matricula> matriculas;
	/*
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "professor_turma_disciplina",
		joinColumns = { @JoinColumn(name = "codigo_turma", referencedColumnName = "codigo", nullable = false)},
		inverseJoinColumns = { @JoinColumn(name = "registro_professor", referencedColumnName = "registro")}
	)
	private List<Professor> professores;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "professor_turma_disciplina",
		joinColumns = { @JoinColumn(name = "codigo_turma", referencedColumnName = "codigo", nullable = false)},
		inverseJoinColumns = { @JoinColumn(name = "codigo_disciplina", referencedColumnName = "codigo")}
	)
	private List<Disciplina> disciplinas;
	*/
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "professor_turma_disciplina",
		joinColumns = { @JoinColumn(name = "codigo_turma", referencedColumnName = "codigo", nullable = false)},
		inverseJoinColumns = { @JoinColumn(name = "codigo_professor", referencedColumnName = "registro")}
	)
	@MapKeyJoinColumn(name = "codigo")
	private Map<Disciplina, Professor> professores;
	
	public Turma() {
		this.matriculas = new ArrayList<>();
		this.professores = new HashMap<>();
//		this.disciplinas = new ArrayList<>();
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
	 * @return the professores
	 */
	public Map<Disciplina, Professor> getProfessores() {
		return professores;
	}

	/**
	 * @param professores the professores to set
	 */
	public void setProfessores(Map<Disciplina, Professor> professores) {
		this.professores = professores;
	}
}
