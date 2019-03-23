package com.akomlev.demo;
import com.akomlev.demo.repositories.SubscriptionRepository;
import com.akomlev.demo.configuration.MyWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//@SpringBootApplication
//@SpringBootApplication(scanBasePackages= "com")
//@ComponentScan({"com.akomlev.demo"})
//@EntityScan("com.akomlev.demo.repositories.SubscriptionRepository")
//@EnableJpaRepositories("com.akomlev.demo.repositories")

@SpringBootApplication(scanBasePackages = { "com.akomlev.demo" })
@EnableJpaRepositories(basePackages="com.akomlev.demo.repositories")
@EntityScan("com.akomlev.demo.models")
public class DemoApplication extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { MyWebConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}