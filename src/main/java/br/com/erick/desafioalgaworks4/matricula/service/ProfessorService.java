package br.com.erick.desafioalgaworks4.matricula.service;

import javax.inject.Inject;

import br.com.erick.desafioalgaworks4.matricula.dao.DAO;
import br.com.erick.desafioalgaworks4.matricula.modelo.Professor;

/**
 * Classe responsavel pela regra de negocio para a entidade {@link Professor}.
 * @author Erick Alves
 *
 */
public class ProfessorService extends AbstractService<Professor> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAO<Professor> professorDAO;

	@Override
	protected DAO<Professor> getDAO() {
		return this.professorDAO;
	}
}
