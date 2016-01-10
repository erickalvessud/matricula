package br.com.erick.desafioalgaworks4.matricula.service;

import javax.inject.Inject;

import br.com.erick.desafioalgaworks4.matricula.dao.DAO;
import br.com.erick.desafioalgaworks4.matricula.modelo.Matricula;

/**
 * Classe responsavel pela regra de negocio para a entidade {@link Matricula}.
 * @author Erick Alves
 *
 */
public class MatriculaService extends AbstractService<Matricula> {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private DAO<Matricula> matriculaDAO;
	
	public MatriculaService() {

	}
	
	@Override
	protected DAO<Matricula> getDAO() {
		return matriculaDAO;
	}
}
