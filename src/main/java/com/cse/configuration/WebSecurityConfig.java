package com.cse.configuration;

import static com.cse.security.utils.SecurityConstants.LOGIN_ENDPOINT;
import static com.cse.security.utils.SecurityConstants.REGISTRATION_ENDPOINT;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.cse.security.JwtAuthenticationFilter;
import com.cse.security.JwtAuthorizationFilter;
import com.cse.security.utils.SecurityUtils;
import com.cse.security.utils.UserDetailsServiceImpl;
import com.cse.service.AccountService;
import com.cse.service.UserService;
import com.cse.service.api.IUserService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
			.and()
				.csrf()
					.disable()
				.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.POST, LOGIN_ENDPOINT, REGISTRATION_ENDPOINT)
						.permitAll()
					.antMatchers(HttpMethod.OPTIONS)
						.permitAll()
					.antMatchers(HttpMethod.GET, SecurityUtils.getPublicEndpoints())
						.permitAll()
					.anyRequest()
						.authenticated()
			.and()
				.addFilter(jwtAuthenticationFilter())
				.addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// the user details service and the password encoder to be used in the
		// authenticated() method of authenticationManager of the JwtAuthentication Filter

		auth.userDetailsService(userDetailsServiceBean())
		 .passwordEncoder(passwordEncoder());

	}

	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new UserDetailsServiceImpl(userService());
	}

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
		final JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
		filter.setAuthenticationManager(authenticationManager());
		filter.setFilterProcessesUrl(LOGIN_ENDPOINT);
		return filter;
	}

	@Bean
	public AccountService accountService() {
		return new AccountService();
	}
	
	@Bean
	public IUserService userService() {
		return new UserService();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
		configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
