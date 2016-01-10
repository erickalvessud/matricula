package br.com.erick.desafioalgaworks4.matricula.service;

import javax.inject.Inject;

import br.com.erick.desafioalgaworks4.matricula.dao.DAO;
import br.com.erick.desafioalgaworks4.matricula.modelo.Disciplina;

/**
 * Classe responsavel pela regra de negocio para a entidade {@link Disciplina}.
 * @author Erick Alves
 *
 */
public class DisciplinaService extends AbstractService<Disciplina> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DAO<Disciplina> disciplinaDAO;
	
	public DisciplinaService() {

	}
	
	@Override
	protected DAO<Disciplina> getDAO() {
		return this.disciplinaDAO;
	}
}
