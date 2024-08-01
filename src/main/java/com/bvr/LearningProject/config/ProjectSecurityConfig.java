package com.bvr.LearningProject.config;

import com.bvr.LearningProject.enums.Authorities;
import com.bvr.LearningProject.enums.UserRoles;
import com.bvr.LearningProject.filter.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;


@Configuration
public class ProjectSecurityConfig {

    /**
     * Below is the custom security configurations
     */

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        CsrfTokenRequestAttributeHandler csrfToken = new CsrfTokenRequestAttributeHandler();
        csrfToken.setCsrfRequestAttributeName("_csrf");

        httpSecurity.securityContext((context) -> context.requireExplicitSave(false))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .cors(corsCustomizer -> corsCustomizer.configurationSource(request -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
                    corsConfiguration.setAllowCredentials(true);
                    corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
                    corsConfiguration.setMaxAge(3600L);
                    return corsConfiguration;
                }))
                .csrf((csrf) -> csrf.csrfTokenRequestHandler(csrfToken).ignoringRequestMatchers("/contact", "/register")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests((request) -> request
//                        .requestMatchers("/myAccount").hasAuthority(Authorities.VIEW_ACCOUNT.getName())
//                        .requestMatchers("/myBalance").hasAnyAuthority(Authorities.VIEW_ACCOUNT.getName(), Authorities.VIEW_BALANCE.getName())
//                        .requestMatchers("/myLoans").hasAuthority(Authorities.VIEW_LOANS.getName())
//                        .requestMatchers("/myCards").hasAuthority(Authorities.VIEW_CARDS.getName())


                        .requestMatchers("/myAccount").hasRole(UserRoles.USER.getName())
                        .requestMatchers("/myBalance").hasAnyRole(UserRoles.USER.getName(), UserRoles.ADMIN.getName())
                        .requestMatchers("/myLoans").hasRole(UserRoles.USER.getName())
                        .requestMatchers("/myCards").hasRole(UserRoles.USER.getName())


                        .requestMatchers("/user").authenticated()
                        .requestMatchers("/notices", "/contact", "/register").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
