package br.com.erick.desafioalgaworks4.matricula.service;

import java.util.List;

import br.com.erick.desafioalgaworks4.matricula.dao.DAO;
import br.com.erick.desafioalgaworks4.matricula.util.jpa.Transactional;

public abstract class AbstractService<E> implements ServiceInterface<E> {

	private static final long serialVersionUID = 1L;

	@Override
	public void buscarPorCodigo(Object id) throws NegocioException {
		this.getDAO().buscarPorCodigo(id);
	}

	@Override
	@Transactional
	public void salvar(E entidade) throws NegocioException {
		this.getDAO().salvar(entidade);
	}

	@Override
	@Transactional
	public void excluir(E entidade) throws NegocioException {
		this.getDAO().excluir(entidade);
	}

	@Override
	public List<E> listarTodos() throws NegocioException {
		return this.getDAO().listarTodos();
	}

	protected abstract DAO<E> getDAO();
}
