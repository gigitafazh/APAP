package com.example;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable();
		http
			.authorizeRequests()
			.antMatchers("/**").hasRole("KAPRODI")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout()
			.permitAll();
	}
	
//	@Autowired
//	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception
//	{
//		auth.inMemoryAuthentication()
//			.withUser("user").password("password")
//			.roles("USER");
//		auth.inMemoryAuthentication()
//			.withUser("admin").password("admin")
//			.roles("ADMIN");
//		
//	}
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(
			"select username,password, id_role, nama from users where username=?"		
			)
			.authoritiesByUsernameQuery(
			"select a.username, b.nama_role from users as a, roles as b where a.username=? and a.id_role = b.id"		
			);
	}
}