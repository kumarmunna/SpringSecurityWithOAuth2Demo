/**
 * 
 */
package com.springsecurity.securityconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * @author santoshkumar_si
 * @date 10-Sep-2019
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "resource_id";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		System.out.println(" In configure(ResourceServerSecurityConfigurer resources)");
		resources.resourceId(RESOURCE_ID).stateless(false);
	}	

	@Override
	public void configure(HttpSecurity http) throws Exception {
		System.out.println(" In resource configure(HttpSecurity http)");
		 http.
         anonymous().disable()
         .authorizeRequests()
         .antMatchers("/users/**").authenticated()
         .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

}