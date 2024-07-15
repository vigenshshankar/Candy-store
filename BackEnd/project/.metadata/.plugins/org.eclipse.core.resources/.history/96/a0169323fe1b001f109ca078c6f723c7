package com.cg.onlinesweetmart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cg.onlinesweetmart.security.JwtAuthenticationEntryPoint;
import com.cg.onlinesweetmart.security.JwtAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class SpringSecurityConfig {
	
	private UserDetailsService userDetailsService;
	
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	
	private JwtAuthenticationFilter authenticationFilter;

    @Bean
    static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((authorize) -> {
				authorize.requestMatchers("/api/auth/**").permitAll();
				authorize.anyRequest().authenticated();
			})
			.httpBasic(Customizer.withDefaults());
		
		http.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint));
		
		http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
//	@Bean
//	public UserDetailsService userDetailService() {
//		
//		UserDetails harish = User.builder()
//								.username("harish")
//								.password(passwordEncoder().encode("1234"))
//								.roles("USER")
//								.build();
//		
//		UserDetails kevin = User.builder()
//								.username("kevin")
//								.password(passwordEncoder().encode("4321"))
//								.roles("ADMIN")
//								.build();
//		
//		return new InMemoryUserDetailsManager(harish, kevin);
//		
//	}
	
}
