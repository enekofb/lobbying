package org.lobbying;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = {
		PolicyApplication.class },
		basePackages = "org.lobbying")
public class PolicyApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(PolicyApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(PolicyApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	@Qualifier("policy")
	public org.lobbying.policy.mapper.PolicyMapper policyMapper() {
		return new org.lobbying.policy.mapper.PolicyMapper();
	}


	@Bean
	@Qualifier("citizen")
	public org.lobbying.citizen.mapper.PolicyMapper citizenPolicyMapper() {
		return new org.lobbying.citizen.mapper.PolicyMapper();
	}


}