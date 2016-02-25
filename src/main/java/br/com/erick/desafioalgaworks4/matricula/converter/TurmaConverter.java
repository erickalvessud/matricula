package br.com.erick.desafioalgaworks4.matricula.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.erick.desafioalgaworks4.matricula.dao.DAO;
import br.com.erick.desafioalgaworks4.matricula.dao.TurmaDAO;
import br.com.erick.desafioalgaworks4.matricula.modelo.Turma;
import br.com.erick.desafioalgaworks4.matricula.service.NegocioException;
import br.com.erick.desafioalgaworks4.matricula.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Turma.class)
public class TurmaConverter implements Converter {

	private DAO<Turma> turmaDAO;

	public TurmaConverter() {
		this.turmaDAO = CDIServiceLocator.getBean(TurmaDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Turma retorno = null;

		if (value != null) {
			try {
				retorno = ((TurmaDAO)this.turmaDAO).buscarPorCodigo(new Long(value));
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
			Long codigoTurma = ((Turma) value).getCodigo();
			String retorno = (codigoTurma == null ? null : codigoTurma.toString());

			return retorno;
		}

		return "";
	}

}