package org.shinseonghwa.springbootdeveloper.config;

import lombok.RequiredArgsConstructor;
import org.shinseonghwa.springbootdeveloper.service.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {

    private final UserDetailService userDetailService;

    // 스프링 시큐리티 기능 비활성화
    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers(toH2Console())     // h2 콘솔 관련 비활성화
                .requestMatchers("/static/**");     // 정적 리소스 비활성화
    }

    // 특정 HTTP 요청에 대한 웹 기반 보안 구성
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()    // 인증, 인가 설정
                .requestMatchers("/login", "/signup", "/user").permitAll()   // 인증, 인가 없이 누구나 접근가능 (permitAll)
                .anyRequest()   // 위에서 설정한 URL 이외(anyRequest)
                .authenticated()   // 인가는 필요없음, 인증은 필요 (authenticated)
                .and()
                .formLogin()    // 폼 기반 로그인 설정
                .loginPage("/login")
                .defaultSuccessUrl("/articles")
                .and()
                .logout()   // 로그아웃 설정
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)    // 로그아웃 이후 세션을 전체 삭제할지 여부
                .and()
                .csrf().disable()   // CSRF 공격에 대해 비활성화 (학습 편의상)
                .build();
    }

    // 인증 관리자 관련 설정
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http,
                                                       BCryptPasswordEncoder bCryptPasswordEncoder,
                                                       UserDetailService userDetailService) throws Exception {
        return http
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and().build();
    }
    
    // 패스워드 인코더로 사용할 빈 등록
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
