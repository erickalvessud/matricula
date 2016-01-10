package br.com.erick.desafioalgaworks4.matricula.service;

import javax.inject.Inject;

import br.com.erick.desafioalgaworks4.matricula.dao.DAO;
import br.com.erick.desafioalgaworks4.matricula.modelo.Aluno;

/**
 * Classe responsavel pela regra de negocio para a entidade {@link Aluno}.
 * @author Erick Alves
 *
 */
public class AlunoService extends AbstractService<Aluno>{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAO<Aluno> alunoDAO;
	
	public AlunoService(){

	}
	
	@Override
	protected DAO<Aluno> getDAO() {
		return this.alunoDAO;
	}

}
