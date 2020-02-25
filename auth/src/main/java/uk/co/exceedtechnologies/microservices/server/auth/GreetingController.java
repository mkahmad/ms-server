package uk.co.exceedtechnologies.microservices.server.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface GreetingController {
	@RequestMapping("/greeting")
	String greeting();
}
