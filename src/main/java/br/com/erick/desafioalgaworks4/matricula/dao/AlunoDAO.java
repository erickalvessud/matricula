package br.com.erick.desafioalgaworks4.matricula.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import br.com.erick.desafioalgaworks4.matricula.modelo.Aluno;

public class AlunoDAO extends DAO<Aluno> {

	@Inject
	public AlunoDAO(EntityManager entityManager, Logger logger) {
		super(entityManager, logger);
	}
	
	@Override
	public Class<Aluno> getEntityClass() {
		return Aluno.class;
	}
}
