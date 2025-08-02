package com.rubypaper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	// UserDetailsServiceImpl 객체 주입
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		// 브라우저가 CSRF 토큰을 전달하지 않아도 인증을 처리하는 설정
		security.csrf(csrf -> 
			csrf.disable());
		
		// 인증과 인가를 처리하는 설정
		security.authorizeHttpRequests(authorize -> 
			// url 상에 member 경로가 포함된 모든 요청은 인증에 성공해야 한다.
			authorize.requestMatchers("/member/**").authenticated()
			// url 상에 manager 경로가 포함된 모든 요청은 인증에 성공하고 MANGER 권한을 가져야 한다.
	                 .requestMatchers("/manager/**").hasRole("MANAGER")
			// url 상에 manager 경로가 포함된 모든 요청은 인증에 성공하고 ADMIN 권한을 가져야 한다.
        			 .requestMatchers("/admin/**").hasRole("ADMIN")
        	// 위 세 경로를 제외한 나머지 url 경로는 로그인 없이 요청 가능하다.
        			 .anyRequest().permitAll());
		
		// 로그인 페이지 설정
		security.formLogin(login -> 
			// login 인증이 필요한 페이지를 요청할 때, /login 요청을 리디렉트해라.
			login.loginPage("/login")
			// 로그인 성공했을 때, /success 요청을 리디렉트해라.
			     .defaultSuccessUrl("/success", true));
		
		// 로그아웃 설정
		security.logout(logout -> logout.invalidateHttpSession(true)
				.logoutSuccessUrl("/login"));
		
		// 사용자 정의 UserDetailsService 적용
		security.userDetailsService(userDetailsService);
		
		return security.build();
	}
}







