//package com.nnh.config;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.nnh.dal.reposiroty.RoleRepository;
//import com.nnh.model.convert.UserConvert;
//import com.nnh.model.entity.UserEntity;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//	@Autowired
//	private HttpSession session;
//	
//	@Autowired
//	private RoleRepository roleRep;
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.authorizeRequests()
//			.antMatchers("/", "/trang-chu", "/tim-kiem", "/can-ho", "/register", "/**").permitAll()
//			.antMatchers("/admin/**").hasRole("ADMIN")
//		.and().formLogin()
//			.loginPage("/login")
//			.defaultSuccessUrl("/trang-chu")
//			.failureUrl("/login?message=loginFail")
//			.loginProcessingUrl("/login");
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser(((UserEntity) session.getAttribute("USERMODEL")).getUsername())
//		.password(passwordEncoder().encode(((UserEntity) session.getAttribute("USERMODEL")).getPassword()))
//		.authorities(roleRep.findById(((UserEntity) session.getAttribute("USERMODEL")).getRoles().get(0).getId()).get().getCode());
//	}
//}
