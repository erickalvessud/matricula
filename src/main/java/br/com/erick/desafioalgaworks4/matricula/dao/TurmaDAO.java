package br.com.erick.desafioalgaworks4.matricula.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import br.com.erick.desafioalgaworks4.matricula.modelo.Turma;

/**
 * Camada de persistencia da entidade {@link Turma}.
 * @author Erick Alves
 *
 */
public class TurmaDAO extends DAO<Turma>{

	@Inject
	public TurmaDAO(EntityManager entityManager, Logger logger) {
		super(entityManager, logger);
	}

	@Override
	protected Class<Turma> getEntityClass() {
		return Turma.class;
	}
}
