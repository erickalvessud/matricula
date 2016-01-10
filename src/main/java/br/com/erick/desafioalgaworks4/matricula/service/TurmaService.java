package br.com.erick.desafioalgaworks4.matricula.service;

import javax.inject.Inject;

import br.com.erick.desafioalgaworks4.matricula.dao.DAO;
import br.com.erick.desafioalgaworks4.matricula.modelo.Turma;

/**
 * Classe responsavel pela regra de negocio para a entidade {@link Turma}.
 * @author Erick Alves
 *
 */
public class TurmaService extends AbstractService<Turma> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DAO<Turma> turmaDAO;
	
	@Override
	protected DAO<Turma> getDAO() {
		return this.turmaDAO;
	}

}
