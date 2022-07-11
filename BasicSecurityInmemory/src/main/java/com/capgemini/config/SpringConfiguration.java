package com.capgemini.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*	auth.inMemoryAuthentication()
	.withUser("priya")
	.password("pass")
	.roles("USER");
	*/
		
		auth.inMemoryAuthentication()
		.withUser("priya")
		.password(bCryptPasswordEncoder().encode("pass"))
		.roles("USER")
		.and()
		.withUser("kushal")
		.password(bCryptPasswordEncoder().encode("pass"))
		.roles("ADMIN");
	}
	
/*	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	*/
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/**")
		.hasAnyRole("USER","ADMIN")
		.antMatchers("/admin/**")
		.hasRole("ADMIN")
		.antMatchers("/")
		.permitAll()
		.and()
	//	.httpBasic(); //no logout page
		.formLogin(); //includes login and logout page
	}
}
