package academy.devdojo.springboot2.config;

import academy.devdojo.springboot2.service.DevDojoUserDetailsService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger log = LogManager.getLogger(SecurityConfig.class);
	private final DevDojoUserDetailsService devDojoUserDetailsService;

	public SecurityConfig(DevDojoUserDetailsService devDojoUserDetailsService) {
		this.devDojoUserDetailsService = devDojoUserDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/animes/admin/**").hasRole("ADMIN")
				.antMatchers("/animes/**").hasRole("USER")
				.antMatchers("/actuator/**").permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.and()
				.httpBasic();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		log.info("Password encoded {}", passwordEncoder.encode("PASSWORD_TO_BE_ENCODED"));
		
		auth.inMemoryAuthentication()
				.withUser("spring")
				.password(passwordEncoder.encode("boot"))
				.roles("USER", "ADMIN");
		
		auth.userDetailsService(devDojoUserDetailsService)
        		.passwordEncoder(passwordEncoder);
	}

}
