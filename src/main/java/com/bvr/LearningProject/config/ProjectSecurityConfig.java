package com.bvr.LearningProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    /**
     *  Below is the custom security configurations
     */

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
/*
        httpSecurity.authorizeHttpRequests((requests) -> requests.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                        .requestMatchers("/notices", "/contact").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
*/


        /**
         *  Configuration to deny all the requests
         */
        /*httpSecurity.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
*/
        /**
         *  Configuration to permit all the requests
         */
        httpSecurity.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

}
