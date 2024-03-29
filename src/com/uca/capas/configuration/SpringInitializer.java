package com.uca.capas.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.uca.capas.configuration.SpringConfiguration;

public class SpringInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx= new AnnotationConfigWebApplicationContext();
		ctx.register(SpringConfiguration.class);
		ctx.setServletContext(servletContext);
		
		ServletRegistration.Dynamic serDynamic=servletContext.addServlet("spring-capas", new DispatcherServlet(ctx));
		serDynamic.addMapping("/");
		serDynamic.setLoadOnStartup(1);
	}
	
}