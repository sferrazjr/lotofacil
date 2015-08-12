package br.com.jogatina.lotofacil.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;


@Configuration
@ComponentScan
@EnableWebMvc
public class LotofacilAppConfiguration extends WebMvcConfigurerAdapter {	
	//public class ServerConfiguration extends WebMvcAutoConfiguration{

//	private static final Logger logger = LoggerFactory.getLogger(ServerConfiguration.class);

//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.enableContentNegotiation(new MappingJackson2JsonView());
//		registry.freeMarker().cache(false);
//		registry.freeMarker().prefix("");
//		registry.freeMarker().suffix(".ftl");
//
//		logger.error("configureViewResolvers");
//	}
	
	@Bean
	public ViewResolver viewResolver() {
	    FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
	    resolver.setCache(true);
	    resolver.setPrefix("");
	    resolver.setSuffix(".ftl");
	    return resolver;

	}	

	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPath("classpath:/freemarker/");
		configurer.setDefaultEncoding("UTF-8");
		
		return configurer;
	}
	
//	@Bean
//	public FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean(){
//		FreeMarkerConfigurationFactoryBean configurationFactoryBean = new FreeMarkerConfigurationFactoryBean();
//		configurationFactoryBean.setTemplateLoaderPath("classpath:/freemarker/");
//
//		return configurationFactoryBean;
//	}
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/scripts/**").addResourceLocations("classpath:/static/scripts/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}	


}