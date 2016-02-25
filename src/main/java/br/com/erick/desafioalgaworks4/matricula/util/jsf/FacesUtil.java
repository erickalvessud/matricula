package br.com.erick.desafioalgaworks4.matricula.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Classe com metodos comuns para trabalhar com as funcionalidades
 * disponibilizadas pelo contexto JSF.
 * 
 * @author Erick Alves
 *
 */
public class FacesUtil {

	/**
	 * Adiciona a fila de mensagens do contexto JSF uma mensagem informativa
	 * para ser exibida para o usuario.
	 * 
	 * @param message
	 *            Mensagem que sera exibida
	 */
	public static void addSuccessMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}

	/**
	 * Adiciona a fila de mensagens do contexto JSF uma mensagem de alerta para
	 * ser exibida para o usuario.
	 * 
	 * @param message
	 *            Mensagem que sera exibida
	 */
	public static void addWarnMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
	}

	/**
	 * Adiciona a fila de mensagens do contexto JSF uma mensagem de erro para
	 * ser exibida para o usuario.
	 * 
	 * @param message
	 *            Mensagem que sera exibida
	 */
	public static void addErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}

	/**
	 * Adiciona a fila de mensagens do contexto JSF uma mensagem fatal para ser
	 * exibida para o usuario.
	 * 
	 * @param message
	 *            Mensagem que sera exibida
	 */
	public static void addFatalMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, message, message));
	}
}
