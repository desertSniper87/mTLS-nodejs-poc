package com.example.mtlsdemo;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MtlsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtlsDemoApplication.class, args);
	}

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.anyRequest()
//				.authenticated()
//				.and()
//				.x509()
//				.subjectPrincipalRegex("CN=(.*?)(?:,|$)")
//				.userDetailsService(userDetailsService());
//		return http.build();
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new UserDetailsService() {
//			@Override
//			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////				if (username.equals("torsho")) {
//					return new User(username, "", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
////				}
////				throw new UsernameNotFoundException("User not found!");
//			}
//		};
//	}

}

