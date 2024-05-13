package com.backend.androidProjectBE.Security;

import com.backend.androidProjectBE.Configuration.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class CustomerFilterFilterSecurity {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder().encode("user1Pass"))
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder().encode("user2Pass"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("adminPass"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, admin);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(config -> config.requestMatchers(HttpMethod.GET, Endpoint.PUBLIC_GET_ENDPOINS)
//                .permitAll().requestMatchers(HttpMethod.GET, Endpoint.ADMIN_GET_ENDPOINS)
//                .hasAnyAuthority("ADMIN", "STAFF").requestMatchers(HttpMethod.POST, Endpoint.ADMIN_POST_ENDPOINS)
//                .hasAnyAuthority("ADMIN", "STAFF").requestMatchers(HttpMethod.POST, Endpoint.PUBLIC_POST_ENDPOINS)
//                .permitAll());
//        http.cors(cors -> {
//            cors.configurationSource(request -> {
//                CorsConfiguration corsConfig = new CorsConfiguration();
//                corsConfig.addAllowedOrigin(Endpoint.front_end_host);
//                corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
//                corsConfig.addAllowedHeader("*");
//                return corsConfig;
//            });
//        });
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        http.httpBasic(Customizer.withDefaults());
//        http.csrf(csrf -> csrf.disable());
//        return http.build();
//    }
//    @Bean

}
