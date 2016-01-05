package br.com.erick.desafioalgaworks4.matricula.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.erick.desafioalgaworks4.matricula.dao.AlunoDAO;
import br.com.erick.desafioalgaworks4.matricula.dao.DAO;
import br.com.erick.desafioalgaworks4.matricula.modelo.Aluno;
import br.com.erick.desafioalgaworks4.matricula.service.NegocioException;
import br.com.erick.desafioalgaworks4.matricula.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Aluno.class)
public class AlunoConverter implements Converter {
	
	private DAO<Aluno> alunoDAO;
	
	public AlunoConverter() {
		this.alunoDAO = CDIServiceLocator.getBean(AlunoDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Aluno retorno = null;

		if (value != null) {
			try {
				retorno = this.alunoDAO.buscarPorCodigo(new Long(value));
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
			Long ra = ((Aluno) value).getRegistroAluno();
			String retorno = (ra == null ? null : ra.toString());
			
			return retorno;
		}
		
		return "";
	}

}