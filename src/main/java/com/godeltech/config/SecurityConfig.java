package com.godeltech.config;

import com.godeltech.config.jwt.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private final JwtFilter jwtFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/authentication/auth", "/authentication/auth/*","/signout").permitAll()
                .antMatchers("/v3/api-docs/**").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/users/**").hasAnyRole("ADMIN")
                .antMatchers("/airplanes/**").hasAnyRole("ADMIN","FLIGHTMANAGER")
                .antMatchers("/airports/**").hasAnyRole("ADMIN","FLIGHTMANAGER")
                .antMatchers("/captains/**").hasAnyRole("ADMIN","FLIGHTMANAGER")
                .antMatchers("/categories/**").hasAnyRole("ADMIN","FLIGHTMANAGER")
                .antMatchers("/engineers/**").hasAnyRole("ADMIN","FLIGHTMANAGER")
                .antMatchers("/start/statuses/**").hasAnyRole("ADMIN")
                .antMatchers("/progress/statuses/**").hasAnyRole("ADMIN")
                .antMatchers("/secondpilots/**").hasAnyRole("ADMIN","FLIGHTMANAGER")
                .antMatchers("/stewardesses/**").hasAnyRole("ADMIN","FLIGHTMANAGER")
                .antMatchers("/stewardesses/**").hasAnyRole("ADMIN","FLIGHTMANAGER")
                .antMatchers(HttpMethod.PATCH,"/flights/**").hasAnyRole("ADMIN","FLIGHTMANAGER")
                .antMatchers("/flights/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/flights/**").hasRole("PROGRESSDISPATCHER")
                .antMatchers(HttpMethod.PUT,"/flights/**").hasRole("PROGRESSDISPATCHER")
                .antMatchers(HttpMethod.DELETE,"/flights/**").hasRole("PROGRESSDISPATCHER")
                .antMatchers(HttpMethod.POST,"/flights/**").hasRole("PROGRESSDISPATCHER")
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
