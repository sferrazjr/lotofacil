package br.com.jogatina.lotofacil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@ComponentScan(basePackages = {"br.com.jogatina.lotofacil"})
@EnableWebMvc
public class WebConfiguration {

	@Bean
	public FreeMarkerConfigurer freeMarkerConfig(){
		
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();		
		configurer.setTemplateLoaderPath("classpath:/freemarker/");
		
		return configurer;
	}
	
	@Bean
	public FreeMarkerViewResolver viewResolver(){
		
		FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
		freeMarkerViewResolver.setCache(true);
		freeMarkerViewResolver.setPrefix("");
		freeMarkerViewResolver.setSuffix(".ftl");
		
		return freeMarkerViewResolver;
	}
	
}
