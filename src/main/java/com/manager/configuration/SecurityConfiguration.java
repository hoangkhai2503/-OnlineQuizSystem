package com.manager.configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.manager.service.CompositeUserDetailsService;
import com.manager.service.StudentService;
import com.manager.service.SuperAdminService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	private SuperAdminService superAdminService;
//	@Autowired
//	private final StudentService studentService;
//	@Autowired
//    private final SuperAdminService superAdminService;
//
//    public SecurityConfiguration(StudentService studentService, SuperAdminService superAdminService) {
//        this.studentService = studentService;
//        this.superAdminService = superAdminService;
//    }
//
//    @Bean
//    public CompositeUserDetailsService compositeUserDetailsService() {
//        return new CompositeUserDetailsService(studentService, superAdminService);
//    }
//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(compositeUserDetailsService()).passwordEncoder(encoder());
//    }
//

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.cors(cor -> cor.disable())
				.csrf(csf -> csf.disable())
				.authorizeHttpRequests(auth -> {
					auth
					.requestMatchers("/user/**","/admin/assets/**","/admin/login","/user/login/**").permitAll() 
					.requestMatchers("/admin/role","/admin/superadmin","/admin/createdAdmin").hasRole("SUPERADMIN")
		             .requestMatchers("/admin/**").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER");
					// cấu hình đường link dẫn đến css và js
					auth.requestMatchers("/assets/**", "img/**").permitAll();
				})
				.formLogin(formLogin -> {
					formLogin.loginPage("/admin/login").loginProcessingUrl("/admin/process-login")
					.usernameParameter("username")
					.passwordParameter("password")
					.successHandler(new AuthenticationSuccessHandler() {
						@Override
						public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
								Authentication authentication) throws IOException, ServletException {
							String targetUrl = determineTargetUrl(authentication);
							response.sendRedirect(targetUrl);
						}
						 protected String determineTargetUrl(Authentication authentication) {
			                    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
			                    for (GrantedAuthority authority : authorities) {
			                        if (authority.getAuthority().equals("ROLE_SUPERADMIN")) {
			                            return "/admin"	;
			                        }else if (authority.getAuthority().equals("ROLE_ADMIN")) {
			                            return "/admin/class";
			                        }
			                        else if (authority.getAuthority().equals("ROLE_TEACHER")) {
			                            return "/admin/teacher";
			                        }
			                        else if (authority.getAuthority().equals("ROLE_STUDENT")) {
			                            return "/user/home";
			                        }
			                        // Thêm các trường hợp khác tại đây nếu cần
			                    }
			                    throw new IllegalStateException("Invalid user role");
			                }
					}).failureHandler((request, response, exception) -> {
				        request.getSession().setAttribute("errorMsg", "Username or Password incorrect. Please try again.");
				        response.sendRedirect("/admin/login?error");
				    });
				}).logout(logout -> {
					logout.logoutUrl("/admin/logout").logoutSuccessUrl("/account/login");
					;
				}).exceptionHandling(ex -> {
					ex.accessDeniedPage("/admin/error");
				})
				.build();
	}
	@Autowired
	public void configGolbal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(superAdminService);
	}
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
