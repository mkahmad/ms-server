package uk.co.exceedtechnologies.microservices.server.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Lazy;

import com.netflix.discovery.EurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GatewayApplication{

	
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	

}
