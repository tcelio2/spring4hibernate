package com.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Classe mais imporatnte do sistema do ponto de vista da incializacao
 * e sua funcao no sistema.
 * Ela chama todas as classes que tem algo a configurar no sistema.
 * Observe que ela chama o AppWebConfiguration e o JPAConfoiguration.
 * 
 * @author tpereirac
 *
 */
public class ServletSpringConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override//metod que repassa para toda a appplicacao os metoso de condifuracao e bean das mesmas.
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AppWebConfiguration.class, JPAConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
}
