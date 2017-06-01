package com.example.springboot.websocket.p2pcontroller;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
	@Autowired
	DataSource datasouce;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

		http
			.authorizeRequests()
			.antMatchers("/","/login").permitAll()//对/和/login不拦截
				.anyRequest().authenticated()
				.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/main").permitAll()//登陆成功后转向index页面
			.and()
			.logout().logoutSuccessUrl("/login").permitAll();
			//.httpBasic();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//this.disableLocalConfigureAuthenticationBldr = true;
		//内存注册用户授权
//		auth.inMemoryAuthentication()
//			.withUser("wsx")
//			.password("wsx")
//			.roles("USERS")
//			.and()
//			.withUser("zb")
//			.password("zb")
//			.roles("USERS");
		
		auth.jdbcAuthentication().dataSource(datasouce).usersByUsernameQuery("select username,password,authority from user where username=?")
			.authoritiesByUsernameQuery("select username,role from user where username=?");
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/static/**");
	}
}
