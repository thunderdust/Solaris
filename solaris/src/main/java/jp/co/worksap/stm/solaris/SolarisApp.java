package jp.co.worksap.stm.solaris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SolarisApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder sab) {
		return sab.sources(SolarisApp.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SolarisApp.class, args);
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return (container -> {
			ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/403");
			container.addErrorPages(error403Page);
		});
	}
}
