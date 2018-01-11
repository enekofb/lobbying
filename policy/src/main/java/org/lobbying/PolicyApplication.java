package org.lobbying;

import com.opencredo.concursus.domain.events.sourcing.EventSource;
import com.opencredo.concursus.domain.events.state.StateRepository;
import com.opencredo.concursus.mapping.events.methods.state.DispatchingStateRepository;
import com.opencredo.concursus.spring.commands.CommandSystemBeans;
import com.opencredo.concursus.spring.events.EventSystemBeans;
import org.lobbying.domain.Citizen;
import org.lobbying.domain.PolicyState;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = {
		EventSystemBeans.class,
		CommandSystemBeans.class,
		PolicyApplication.class },
		basePackages = "org.lobbying")
public class PolicyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public StateRepository<PolicyState> policyStateRepository(EventSource eventSource) {
		return DispatchingStateRepository.using(eventSource, PolicyState.class);
	}
	@Bean
	public StateRepository<Citizen> citizenStateRepository(EventSource eventSource) {
		return DispatchingStateRepository.using(eventSource, Citizen.class);
	}
}
