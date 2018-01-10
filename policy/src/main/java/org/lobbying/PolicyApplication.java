package org.lobbying;

import com.opencredo.concursus.domain.events.sourcing.EventSource;
import com.opencredo.concursus.domain.events.state.StateRepository;
import com.opencredo.concursus.mapping.events.methods.state.DispatchingStateRepository;
import com.opencredo.concursus.spring.commands.CommandSystemBeans;
import com.opencredo.concursus.spring.events.EventSystemBeans;
import org.lobbying.domain.Citizen;
import org.lobbying.domain.Policy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
		EventSystemBeans.class,
		CommandSystemBeans.class,
		PolicyApplication.class })
@EnableWebMvc
@EnableAutoConfiguration
@Configuration
public class PolicyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyApplication.class, args);
	}

	@Bean
	public StateRepository<Policy> policyStateRepository(EventSource eventSource) {
		return DispatchingStateRepository.using(eventSource, Policy.class);
	}
	@Bean
	public StateRepository<Citizen> citizenStateRepository(EventSource eventSource) {
		return DispatchingStateRepository.using(eventSource, Citizen.class);
	}
}
