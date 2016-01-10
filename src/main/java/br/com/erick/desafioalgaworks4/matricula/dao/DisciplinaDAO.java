package br.com.erick.desafioalgaworks4.matricula.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import br.com.erick.desafioalgaworks4.matricula.modelo.Disciplina;

/**
 * Camada de persistencia da entidade {@link Disciplina}.
 * @author Erick Alves
 *
 */
public class DisciplinaDAO extends DAO<Disciplina> {

	@Inject
	public DisciplinaDAO(EntityManager entityManager, Logger logger) {
		super(entityManager, logger);
	}

	@Override
	protected Class<Disciplina> getEntityClass() {
		return Disciplina.class;
	}

}
