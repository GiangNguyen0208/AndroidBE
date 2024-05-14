package com.backend.androidProjectBE.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomFilterFilterSecurity {

@Autowired
CustomUserDetailService customUserDetailService;
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception  {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailService);

        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors(Customizer.withDefaults())
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return http.build();
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

}
