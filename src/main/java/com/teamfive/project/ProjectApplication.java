package com.teamfive.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	
	List<VendorExtension> vendorExtension = new ArrayList<VendorExtension>();
	Contact contact = new Contact("Team 5", "test.com", "test@mail.com");
	ApiInfo apiInfo = new ApiInfo("Food Application", "Team 5 Project", "version 1", "test.com", contact, "xyz.com", "terms and condition", vendorExtension);
	
	@Bean
	public Docket myDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.teamfive.project")).build().apiInfo(apiInfo);
	}

}
