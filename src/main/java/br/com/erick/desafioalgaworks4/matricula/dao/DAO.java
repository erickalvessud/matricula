package br.com.erick.desafioalgaworks4.matricula.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;

import br.com.erick.desafioalgaworks4.matricula.service.NegocioException;

public abstract class DAO<E> {
	
	protected EntityManager entityManager;
	
	protected Logger logger;
	
	public DAO(EntityManager entityManager, Logger logger){
		this.entityManager = entityManager;
		this.logger = logger;
	}

	public E buscarPorCodigo(Object id) throws NegocioException {
		E retorno = null;
		try {
			retorno = this.entityManager.find(this.getEntityClass(), id) ;
		} catch (IllegalArgumentException e) {
			this.logger.error(e.getMessage());
			throw new NegocioException("Consulta não pode ser realizada");
		}
		return retorno;
	}
	
	public void salvar(E entidade) throws NegocioException {
		try {
			this.entityManager.merge(entidade);
		} catch (PersistenceException | IllegalArgumentException e) {
			this.logger.error(e.getMessage());
			throw new NegocioException("Dados não puderam ser salvos");
		}
	}
	
	public void excluir(E entidade) throws NegocioException {
		try {
			entidade = this.entityManager.merge(entidade);
			this.entityManager.remove(entidade);
			this.entityManager.flush();
		} catch (PersistenceException | IllegalArgumentException e) {
			this.logger.error(e.getMessage());
			throw new NegocioException("Dados não puderam ser removidos");
		}
	}
	
	public List<E> listarTodos() throws NegocioException {
		try {
			String jpql = "FROM " + this.getEntityClass().getSimpleName();
			return this.entityManager.createQuery(jpql, this.getEntityClass()).getResultList();
		} catch (Exception e){
			this.logger.error(e.getMessage());
			throw new NegocioException("Falha ao tentar listar dados");
		}
	}
	
	public abstract Class<E> getEntityClass();
}
