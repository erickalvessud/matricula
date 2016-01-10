package br.com.erick.desafioalgaworks4.matricula.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.erick.desafioalgaworks4.matricula.dao.DAO;
import br.com.erick.desafioalgaworks4.matricula.dao.DisciplinaDAO;
import br.com.erick.desafioalgaworks4.matricula.modelo.Disciplina;
import br.com.erick.desafioalgaworks4.matricula.service.NegocioException;
import br.com.erick.desafioalgaworks4.matricula.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Disciplina.class)
public class DisciplinaConverter implements Converter {
	
	private DAO<Disciplina> disciplinaDAO;
	
	public DisciplinaConverter() {
		this.disciplinaDAO = CDIServiceLocator.getBean(DisciplinaDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Disciplina retorno = null;

		if (value != null) {
			try {
				retorno = this.disciplinaDAO.buscarPorCodigo(new Long(value));
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
			Long codigo = ((Disciplina) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}