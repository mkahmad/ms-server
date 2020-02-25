package uk.co.exceedtechnologies.microservices.server.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

import com.netflix.discovery.EurekaClient;

@SpringBootApplication
public class AuthApplication implements GreetingController{
	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
	
	
	

	public String greeting() {
		
		return String.format(
		          "Hello from '%s'!", eurekaClient.getApplication(appName).getName());
	}
}

