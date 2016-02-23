package br.com.erick.desafioalgaworks4.matricula.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;

import br.com.erick.desafioalgaworks4.matricula.service.NegocioException;

/**
 * Classe abstrata DAO com métodos comuns de persistencia. 
 * @author Erick Alves
 */
public abstract class DAO<E> {
	
	protected EntityManager entityManager;
	
	protected Logger logger;
	
	/**
	 * Construtor.
	 * Possui as dependencias de {@link EntityManager} e de {@link Logger}.
	 * @param entityManager
	 *      - Objeto responsavel pelo comunicacao com o banco de dados.
	 * @param logger
	 *      - Objeto para geracao de logs do sistema.
	 */
	public DAO(EntityManager entityManager, Logger logger){
		this.entityManager = entityManager;
		this.logger = logger;
	}

	/**
	 * Busca uma entidade pelo seu identificador.
	 * @param id
	 *      - Identificador do registro que se deseja obter.
	 * @return
	 *      - Registro(Entidade) correspondente ao codigo passado.
	 * @throws NegocioException
	 *      Caso ocorra algum erro na busca do registro pelo codigo.
	 */
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
	
	/**
	 * Persiste um registro no banco de dados.
	 * @param entidade
	 *      - Registro(Entidade) que se deseja persistir.
	 * @throws NegocioException
	 *      Caso ocorra alguma falha ao tentar persistir o registro.
	 */
	public void salvar(E entidade) throws NegocioException {
		try {
			this.entityManager.merge(entidade);
		} catch (PersistenceException | IllegalArgumentException e) {
			this.logger.error(e.getMessage());
			throw new NegocioException("Dados não puderam ser salvos");
		}
	}
	
	/**
	 * Exclui um registro do banco de dados.
	 * @param entidade
	 *      - Registro(Entidade) que se deseja remover.
	 * @throws NegocioException
	 *      Caso ocorra alguma falha ao tentar excluir o dado.
	 */
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
	
	/**
	 * Metodo realiza uma busca por todos os registros para essa entidade
	 * retornando uma lista de objetos conforme persistidos no banco de dados.
	 * @return
	 *       - Lista com todos os registros de uma entidade.
	 * @throws NegocioException
	 * 		 Caso ocorra alguma falha na busca dos dados.
	 */
	public List<E> listarTodos() throws NegocioException {
		try {
			this.logger.info("listando todos os registros para a entidade: ", this.getClass().getSimpleName());
			String jpql = "FROM " + this.getEntityClass().getSimpleName();
			return this.entityManager.createQuery(jpql, this.getEntityClass()).getResultList();
		} catch (Exception e){
			this.logger.error(e.getMessage());
			throw new NegocioException("Falha ao tentar listar dados");
		}
	}
	
	/**
	 * Retorna o objeto {@link Class} da entidade que esse DAO representa.
	 * @return
	 *       - A classe que representa a entidade criada.
	 */
	protected abstract Class<E> getEntityClass();
}
