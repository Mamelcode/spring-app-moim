package org.edupoll.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(t -> t.disable());
		
		http.authorizeHttpRequests(t-> t
				.requestMatchers("/", "/login", "/login-task", "/join", "/join-task").permitAll()
				.requestMatchers("/moim/**", "/user/**", "/main/**").hasAnyRole("NORMAL", "VIP")
				.anyRequest().authenticated()
		);
		
		http.formLogin(form -> form
//				.usernameParameter("loginId") // 파라미터 바꾸기
//				.passwordParameter("loginPass") // 파라미터 바꾸기
				.loginPage("/login") // 로그인 페이지 커스텀 (컨트롤러)
				.loginProcessingUrl("/login-task") // 로그인 처리 페이지 주소변경(만드는건X)
				.defaultSuccessUrl("/moim/list", true) // 로그인 성공시 보내는곳
//				.successForwardUrl("/moim/list")
		);
		
		http.logout(t -> t.logoutSuccessUrl("/login"));
		
//		http.exceptionHandling(t -> t.accessDeniedPage("/access/dinied"));
		
		return http.build();
	}
}
