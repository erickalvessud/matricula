package br.com.erick.desafioalgaworks4.matricula.util.logging;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe Produtora de loggers personalizados para a classe que o utiliza.
 * 
 * @author Erick
 */
public class LoggerProducer {
	
	@Produces
	public Logger criaLogger(InjectionPoint injectionPoint){
		
		Class<?> clazz = injectionPoint.getMember()
				.getDeclaringClass();
		
		return LoggerFactory.getLogger(clazz.getName());
	}
}
