package br.com.erick.desafioalgaworks4.matricula.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.erick.desafioalgaworks4.matricula.dao.DAO;
import br.com.erick.desafioalgaworks4.matricula.dao.ProfessorDAO;
import br.com.erick.desafioalgaworks4.matricula.modelo.Professor;
import br.com.erick.desafioalgaworks4.matricula.service.NegocioException;
import br.com.erick.desafioalgaworks4.matricula.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Professor.class)
public class ProfessorConverter implements Converter {

	private DAO<Professor> professorDAO;

	public ProfessorConverter() {
		this.professorDAO = CDIServiceLocator.getBean(ProfessorDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Professor retorno = null;

		if (value != null) {
			try {
				retorno = ((ProfessorDAO)this.professorDAO).buscarComDisciplinas(new Long(value));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NegocioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long registroProfessor = ((Professor) value).getCodigo();
			String retorno = (registroProfessor == null ? null : registroProfessor.toString());

			return retorno;
		}

		return "";
	}

}