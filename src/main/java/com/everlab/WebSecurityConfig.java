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
		http.csrf().disable();
		
		http
			.authorizeRequests()
			.antMatchers("/hello","/register","/views/**","/**/*.js","/**/*.css",
					"/**/*.map", "/error*").permitAll()
			.anyRequest() //對象為所有網址
			.authenticated() //存取必須通過驗證
			.and()
			.formLogin() //若未不符合authorize條件，則產生預設login表單
			.loginPage("/login")
				.permitAll()
				.and()
			.logout()
			.permitAll();
			
//	        .and()
//	     		.csrf()
//	     		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
		
		
//			.and()
//			.httpBasic(); //產生基本表單
			
			
	}
	/**
	 * 以上程式碼等同於xml
	 * <http user-expression="true">
	 * <intercept-url pattern=/** access="authenticated"
	 * <form-login />
	 * <http-basic />
	 **/

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// TODO Auto-generated method stub
		auth //Builder Design Pattern
			.inMemoryAuthentication() //自訂Runtime時的使用者帳號
				.withUser("admin") //新增user
				.password("admin12345") //指定密碼
				.roles("ADMIN", "USER") //指派權限群組
				.and() //再新增使用者
				.withUser("user")
				.password("user12345")
				.roles("USER");
	}
	/**
	 *<authentication-manager>
    	<authentication-provider>
    		<user-service>
    			<user name="admin" password="admin12345"  authorities="ROLE_ADMIN, ROLE_USER"/>
    			<user name="user" password="user12345"  authorities="ROLE_USER"/>
    		</user-service>
    	</authentication-provider>
     </authentication-manager>
	 */
	
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		// TODO Auto-generated method stub
//		return new Class<?> []{EverlabApplication.class, WebSecurityConfig.class}; 
//	}
}
