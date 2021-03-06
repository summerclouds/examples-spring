package org.summerclouds.example;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication(scanBasePackages = { "org.summerclouds.example", "org.summerclouds.common.security.jwt"})
public class ExampleHelloServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleHelloServiceApplication.class, args);
	}

	@Autowired
	RequestMappingHandlerMapping requestMappingHandlerMapping;

	@PostConstruct
	public void postMapping() throws Exception {
//        RequestMappingInfo mappingInfo = RequestMappingInfo.paths("/jwt_token").methods(RequestMethod.POST).build();
//        Method method = JwtTokenController.class.getMethod("createToken", long.class);
//        requestMappingHandlerMapping.registerMapping(mappingInfo, new JwtTokenController(), method);
		
		System.out.println("DEBUG INFO:");
		Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping
		        .getHandlerMethods();
		    map.forEach((key, value) -> System.out.println("REST: "+key +"="+value));	
		    
	}
	

}
