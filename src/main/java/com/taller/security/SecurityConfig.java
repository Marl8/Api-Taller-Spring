package com.taller.security;

import com.taller.security.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    AuthenticationProvider provider;

    JwtAuthenticationFilter authenticationFilter;

    public SecurityConfig(AuthenticationProvider provider, JwtAuthenticationFilter authenticationFilter) {
        this.provider = provider;
        this.authenticationFilter = authenticationFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        return security
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(provider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth-> {
                    auth.requestMatchers("/error").permitAll();
                    auth.requestMatchers("/api/v1/login").permitAll();
                    auth.requestMatchers(
                            "/api/**",
                            "/swagger-ui/**",
                            "/swagger-ui.html",
                            "/swagger-resources/**",
                            "/v3/api-docs/**",
                            "/configuration/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/api/v1/cliente")
                            .hasAnyAuthority("READ","CREATED", "UPDATE", "DELETE");
                    auth.requestMatchers("/api/v1/mecanico").hasRole("ADMIN");
                    auth.requestMatchers("/api/v1/repuesto").hasRole("ADMIN");
                    auth.requestMatchers("/api/v1/mecRep").hasRole("ADMIN");
                    auth.requestMatchers("/api/v1/mecdiag").hasRole("ADMIN");
                    auth.requestMatchers("/api/v1/presupuesto").hasAnyRole("ADMIN", "USER");
                    auth.requestMatchers("/api/v1/ficha").hasAnyRole("ADMIN", "USER");
                    auth.requestMatchers("/api/v1/vehiculo").hasAnyRole("ADMIN", "USER");
                    auth.anyRequest().authenticated();
                })
                .build();
    }
}
