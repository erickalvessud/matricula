package br.com.erick.desafioalgaworks4.matricula.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import br.com.erick.desafioalgaworks4.matricula.modelo.Professor;

/**
 * Camada de persistencia da entidade {@link Professor}.
 * @author Erick Alves
 *
 */
public class ProfessorDAO extends DAO<Professor> {

	@Inject
	public ProfessorDAO(EntityManager entityManager, Logger logger) {
		super(entityManager, logger);
	}

	@Override
	protected Class<Professor> getEntityClass() {
		return Professor.class;
	}
}
