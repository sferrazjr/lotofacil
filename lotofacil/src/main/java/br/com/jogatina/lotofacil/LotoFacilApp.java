package br.com.jogatina.lotofacil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories(basePackages="br.com.jogatina.lotofacil.domain")
public class LotoFacilApp {
//extends SpringBootServletInitializer { 
//{//implements WebApplicationInitializer {

	public static void main(String[] args) {
		
	    SpringApplication app = new SpringApplication(LotoFacilApp.class);
	    app.setShowBanner(false);
	    app.run(args);		
	}



//	@Override
//	public SpringApplicationBuilder configure(SpringApplicationBuilder application){
//		return application.sources(LotoFacilApp.class, LotofacilAppConfiguration.class, MongoConfiguration.class);		
//	}
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		registerDispatcherServlet(servletContext);
//	}

//	private void registerDispatcherServlet(final ServletContext servletContext) {
//		WebApplicationContext dispatcherContext = createContext( LotoFacilApp.class );
//		
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
//		
//		//here profiles are activated:
////		dispatcherServlet.setContextInitializers( new SpringMvcExampleProfilesInitializer() );
//		
//		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("bootDispatcher", dispatcherServlet);
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("/lotofacil/**");
//		
//	}

//	private WebApplicationContext createContext(final Class<?>... annotatedClasses) {
//		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//		context.register(annotatedClasses);
//		context.setDisplayName("Lotofacil Boot");
//		
//		return context;
//	}
	
	
}

