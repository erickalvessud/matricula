package br.com.erick.desafioalgaworks4.matricula.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.erick.desafioalgaworks4.matricula.dao.AlunoDAO;
import br.com.erick.desafioalgaworks4.matricula.dao.DAO;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long registroAluno;

	private String nome;
	
	private String email;

	public Long getRegistroAluno() {
		return registroAluno;
	}

	public void setRegistroAluno(Long registroAluno) {
		this.registroAluno = registroAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registroAluno == null) ? 0 : registroAluno.hashCode());
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
		Aluno other = (Aluno) obj;
		if (registroAluno == null) {
			if (other.registroAluno != null)
				return false;
		} else if (!registroAluno.equals(other.registroAluno))
			return false;
		return true;
	}
}
