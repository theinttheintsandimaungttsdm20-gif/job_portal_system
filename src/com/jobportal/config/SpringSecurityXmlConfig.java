package com.jobportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityXmlConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Configure for HttpSercurity");
		/*http.csrf().disable().authorizeRequests().anyRequest()
			.authenticated().and()
			.httpBasic().and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
		http.csrf().disable().authorizeRequests()
			.antMatchers("/homePath").permitAll()
			.antMatchers("/user/**").access("hasRole('USER')")
			.antMatchers("/admin/**").access("hasRole('ADMIN')")
			.and()
			.formLogin()
			.and()
			.exceptionHandling().accessDeniedPage("/accessDeniedPath");		
	}

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("Configure for authentication");
		auth.inMemoryAuthentication()
			.withUser("susu").password("susu").roles("USER")
			.and()
			.withUser("admin").password("admin")
			.credentialsExpired(false)
			.accountExpired(false)
			.accountLocked(false)
			.authorities("WRITE_PRIVILEGES","READ_PRIVILEGES")
			.roles("ADMIN");
			
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
}





