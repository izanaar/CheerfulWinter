package com.izanaar.chwin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheerfulWinterApplication /*extends SpringBootServletInitializer*/{

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(this.getClass());
	}*/

	public static void main(String[] args) {
		SpringApplication.run(CheerfulWinterApplication.class, args);
	}

}
