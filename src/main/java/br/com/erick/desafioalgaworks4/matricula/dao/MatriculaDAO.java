package br.com.erick.desafioalgaworks4.matricula.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import br.com.erick.desafioalgaworks4.matricula.modelo.Matricula;

/**
 * Camada de persistencia da entidade {@link Matricula}.
 * @author Erick Alves
 *
 */
public class MatriculaDAO extends DAO<Matricula> {

	@Inject
	public MatriculaDAO(EntityManager entityManager, Logger logger) {
		super(entityManager, logger);
	}

	@Override
	protected Class<Matricula> getEntityClass() {
		return Matricula.class;
	}

}
