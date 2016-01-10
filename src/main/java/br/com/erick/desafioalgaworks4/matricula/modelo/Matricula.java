package br.com.erick.desafioalgaworks4.matricula.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String observacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_aluno", nullable = false)
	private Aluno aluno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "codigo_turma", nullable = false)
	private Turma turma;

	public Matricula() {

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
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}
	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	/**
	 * @return the aluno
	 */
	public Aluno getAluno() {
		return aluno;
	}
	/**
	 * @param aluno the aluno to set
	 */
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
}
