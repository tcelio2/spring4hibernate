package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spring.controller.HomeController;
import com.spring.dao.AlunoDAO;

/**
 * Apesar de ser uma classe de configuraçao, ela nao usa 
 * o annotation @Configuration.
 * @author tpereirac
 *
 */
//@Configuration //--> so usado quando importamos outra classe de coinfiguracao
@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, AlunoDAO.class})
//@Import({JPAConfiguration.class}) //--> Eu poderia importar
public class AppWebConfiguration {

	@Bean //disponibiliza ao inserir esta classe toda em um scan...
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/files/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	//public MessageSource messageSource(){
		
	//}
	
}
