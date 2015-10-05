package br.com.jogatina.lotofacil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

public class LotoFacilInitializer {
	
}

//public class LotoFacilInitializer implements WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//
//		// Register and map the dispatcher servlet
//		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("lotofacilDispatcher", new DispatcherServlet());
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("/");
//
//	}
//
//}
