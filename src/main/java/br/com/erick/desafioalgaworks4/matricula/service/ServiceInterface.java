package br.com.erick.desafioalgaworks4.matricula.service;

import java.io.Serializable;
import java.util.List;

public interface ServiceInterface<E> extends Serializable {

	public void buscarPorCodigo(Object id) throws NegocioException;
	
	public void salvar(E entidade) throws NegocioException;
	
	public void excluir(E entidade) throws NegocioException;
	
	public List<E> listarTodos() throws NegocioException;
}
