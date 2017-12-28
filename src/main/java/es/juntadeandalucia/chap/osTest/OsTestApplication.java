package es.juntadeandalucia.chap.osTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OsTestApplication  {
	
//	@Override extends SpringBootServletInitializer
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(OsTestApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(OsTestApplication.class, args);
	}
}
