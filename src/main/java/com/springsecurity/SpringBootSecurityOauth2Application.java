package com.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.springsecurity.zuulFilter.AuthHeaderFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableCircuitBreaker
public class SpringBootSecurityOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityOauth2Application.class, args);
	}

	@Bean
	AuthHeaderFilter authHeaderFilter() {
		return new AuthHeaderFilter();
	}
}
