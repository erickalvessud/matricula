package br.com.erick.desafioalgaworks4.matricula.service;

import java.io.Serializable;
import java.util.List;

/**
 * Interface com metodos comuns de CRUD no banco de dados.
 * @author Erick Alves
 *
 * @param <E>
 *      - Entidade para o qual esse metodos irao trabalhar.
 */
public interface ServiceInterface<E> extends Serializable {

	/**
	 * Busca um registro no banco de dados pelo seu codigo.
	 * @param id
	 *      - Identificador do registro.
	 * @throws NegocioException
	 *      Caso ocorra alguma falha na pesquisa.
	 */
	public void buscarPorCodigo(Object id) throws NegocioException;
	
	/**
	 * Persiste o registro no banco de dados.
	 * @param entidade
	 *      - Entidade que se deseja persistir.
	 * @throws NegocioException
	 *      Caso ocorra alguma falha na persistencia.
	 */
	public void salvar(E entidade) throws NegocioException;
	
	/**
	 * Exclui o registro do banco de dados.
	 * @param entidade
	 *      - Entidade que se deseja excluir.
	 * @throws NegocioException
	 *      Caso ocorra alguma falha na exclusao.
	 */
	public void excluir(E entidade) throws NegocioException;
	
	/**
	 * Realiza uma busca de todos os registros persistidos.
	 * @return
	 *       - Retorna uma lista com todos os registros persistidos.
	 * @throws NegocioException
	 *      Caso ocorra alguma falha na pesquisa.
	 */
	public List<E> listarTodos() throws NegocioException;
}
