package com.godeltech.config;

import com.godeltech.config.jwt.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtFilter jwtFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/html/**").permitAll()
                .antMatchers("/css/**", "/js/**", "/image/**", "/favicon.ico").permitAll()
                .antMatchers("/webjars/bootstrap/3.3.7/css/**").permitAll()
                .antMatchers("/webjars/jquery/2.2.4/**").permitAll()
                .antMatchers("/authentication/**").permitAll()
                .antMatchers("/v3/api-docs/**").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/users/**").hasRole("ADMIN")
                .antMatchers("/airplanes/**").hasAnyRole("ADMIN", "FLIGHT-MANAGER","PROGRESS-DISPATCHER")
                .antMatchers("/airports/**").hasAnyRole("ADMIN", "FLIGHT-MANAGER","PROGRESS-DISPATCHER")
                .antMatchers("/captains/**").hasAnyRole("ADMIN", "FLIGHT-MANAGER","PROGRESS-DISPATCHER")
                .antMatchers("/categories/**").hasAnyRole("ADMIN", "FLIGHT-MANAGER","PROGRESS-DISPATCHER")
                .antMatchers("/engineers/**").hasAnyRole("ADMIN", "FLIGHT-MANAGER","PROGRESS-DISPATCHER")
                .antMatchers("/start/statuses/**").hasAnyRole("ADMIN")
                .antMatchers("/progress/statuses/**").hasAnyRole("ADMIN")
                .antMatchers("/second-pilots/**").hasAnyRole("ADMIN", "FLIGHT-MANAGER","PROGRESS-DISPATCHER")
                .antMatchers("/stewardesses/**").hasAnyRole("ADMIN", "FLIGHT-MANAGER","PROGRESS-DISPATCHER")
                .antMatchers(HttpMethod.PATCH, "/flights/**").hasAnyRole("ADMIN", "PROGRESS-DISPATCHER")
                .antMatchers("/flights/**").hasAnyRole("ADMIN","PROGRESS-DISPATCHER","FLIGHT-MANAGER")
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:8080"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setExposedHeaders(Arrays.asList("custom-header1", "custom-header2"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
