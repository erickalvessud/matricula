package br.com.erick.desafioalgaworks4.matricula.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.erick.desafioalgaworks4.matricula.dao.DAO;
import br.com.erick.desafioalgaworks4.matricula.dao.ProfessorDAO;
import br.com.erick.desafioalgaworks4.matricula.modelo.Disciplina;
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
	
	public Professor buscarProfessorComDisciplinas(Long registroProfessor) throws NegocioException {
		
		Professor professor = new Professor();
		
		if (registroProfessor == null) {
			return professor;
		}
		
		professor = ((ProfessorDAO) this.professorDAO).buscarComDisciplinas(registroProfessor);
		
		return professor;
	}
	
	public List<Professor> buscarProfessoresPelaDisciplina(Disciplina disciplina) throws NegocioException {
		List<Professor> professores = new ArrayList<>();
		
		if (disciplina == null) {
			return professores;
		}
		
		professores = ((ProfessorDAO) this.professorDAO).buscarProfessoresPelaDisciplina(disciplina.getCodigo());
		
		return professores;
	}
}
