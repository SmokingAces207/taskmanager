package com.josephocallaghan.taskmanager;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.josephocallaghan.taskmanager.domain.Task;
import com.josephocallaghan.taskmanager.repository.TaskRepository;

@SpringBootApplication
public class TaskManagerApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Print out beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TaskManagerApplication.class);
	}
	
	// Bootstrap some test data into the in-memory database
   @Bean  
   ApplicationRunner init(TaskRepository repository) {  
       return args -> {  
           Stream.of("Buy milk", "Eat pizza", "Write tutorial", "Study Vue.js", "Go kayaking").forEach(name -> {
                   Task task = new Task();
                   task.setTitle(name);
                   task.setDescription(name);
                   task.setDueDate("12/01/2021");
                   task.setPriority("High");
                   task.setComments("Here is a lovely comment");
                   task.setCompleted(false);
                   task.setEditing(false);
                   repository.save(task);
           });
           repository.findAll().forEach(System.out::println);
       };  
   }  

   // Fix the CORS errors
   @Bean
   public FilterRegistrationBean simpleCorsFilter() {
       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
       CorsConfiguration config = new CorsConfiguration();
       config.setAllowCredentials(true);
       // *** URL below needs to match the Vue client URL and port ***
       config.setAllowedOrigins(Collections.singletonList("http://localhost:8080"));
       config.setAllowedMethods(Collections.singletonList("*"));
       config.setAllowedHeaders(Collections.singletonList("*"));
       source.registerCorsConfiguration("/**", config);
       FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
       bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
       return bean;
   }

}
