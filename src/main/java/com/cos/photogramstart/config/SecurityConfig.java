package com.cos.photogramstart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 해당 파일로 시큐리티를 활성화
@EnableWebSecurity

// IoC에 등록
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super를 삭제하게 되면 기존 시큐리티의 기능이 모두 비활성화됨
        // super.configure(http); // URI를 변경하는 아이

        http.csrf().disable();

        // Security 처리에 HttpServletRequest를 이용하여 설정
        http.authorizeRequests()
                // antMatchers : 특정주소
                // authenticated : 인증
                // anyRequest : 모든 요청
                // permitAll : 모든 사용자 접근
                // andPatterns에 있는 주소들은 인증이 있어야 접속이 가능하며, 그 외 요청은 누구나 접근 가능하다.
                .antMatchers("/","/user/**","/image/**","/subscribe/**","/comment/**").authenticated()
                .anyRequest().permitAll()
                // and : 하나의 메소드 설정을 완료할때마다 and를 사용하고 다음 설정을 할 수 있다.
                // formLogin : 로그인 페이지 설정
                // loginPage : 위에 인증이 필요한 경로로 접속하면 설정한 로그인페이지로 리다이렉션됨
                // 로그인 완료시 (/)
                .and()
                .formLogin()
                .loginPage("/auth/signin")
                .defaultSuccessUrl("/");
    }
}