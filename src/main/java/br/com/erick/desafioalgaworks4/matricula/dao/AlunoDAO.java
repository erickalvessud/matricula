package br.com.erick.desafioalgaworks4.matricula.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import br.com.erick.desafioalgaworks4.matricula.modelo.Aluno;
import br.com.erick.desafioalgaworks4.matricula.modelo.Matricula;

/**
 * Camada de persistencia da entidade {@link Aluno}.
 * @author Erick Alves
 *
 */
public class AlunoDAO extends DAO<Aluno> {

	@Inject
	public AlunoDAO(EntityManager entityManager, Logger logger) {
		super(entityManager, logger);
	}
	
	@Override
	protected Class<Aluno> getEntityClass() {
		return Aluno.class;
	}
}
