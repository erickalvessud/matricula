package br.com.erick.desafioalgaworks4.matricula.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;

import org.slf4j.Logger;

import br.com.erick.desafioalgaworks4.matricula.modelo.Professor;
import br.com.erick.desafioalgaworks4.matricula.service.NegocioException;

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
	
	public Professor buscarComDisciplinas(Long registroProfessor) throws NegocioException{
		try {
			Query query = super.entityManager.createQuery("SELECT p FROM Professor p LEFT JOIN FETCH p.disciplinas d WHERE p.codigo = :registroProfessor");
			query.setParameter("registroProfessor", registroProfessor);
			return (Professor) query.getSingleResult();
		} catch (NoResultException nre) {
			super.logger.error("Nao ha resultados para esta busca", nre);
			throw new NegocioException("Nenhuma disciplina encontrada para o professor"+ registroProfessor);
		} catch (NonUniqueResultException nure) {
			super.logger.error("Ha mais de um resultado retornado", nure);
			throw new NegocioException("Um erro ocorreu, contate o administrador do sistema");
		} catch (IllegalStateException ise) {
			super.logger.error("Erro ao tentar buscar um resultado utilizando uma instrucao JPQL UPDATE ou DELETE ao inves de uma instrucao SELECT", ise);
			throw new NegocioException("Um erro ocorreu, contate o administrador do sistema");
		} catch (QueryTimeoutException qte) {
			super.logger.error("Tempo de consulta excedido", qte);
			throw new NegocioException("Um erro ocorreu, contate o administrador do sistema");
		}
	}
}
