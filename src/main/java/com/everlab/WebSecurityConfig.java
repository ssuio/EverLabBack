package com.everlab;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity //Enable springFliterChain
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//disable csrf because customized index page
		http.csrf().disable();
		
		http
			.authorizeRequests()
			.antMatchers("/hello","/register","/views/**","/**/*.js","/**/*.css",
					"/**/*.map", "/error", "/").permitAll()
			.anyRequest() //對象為所有網址
			.authenticated() //存取必須通過驗證
			.and()
			.formLogin() //若未不符合authorize條件，則產生預設login表單
			.loginPage("/error")
				.permitAll()
				.and()
			.logout()
			.permitAll();
		
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth //Builder Design Pattern
			.inMemoryAuthentication() //自訂Runtime時的使用者帳號
				.withUser("ssuio") //新增user
				.password("Abcd1234") //指定密碼
				.roles("ADMIN", "USER"); //指派權限群組
				
//				.and() //再新增使用者
//				.withUser("user")
//				.password("user")
//				.roles("USER");
	}
	
	
}
