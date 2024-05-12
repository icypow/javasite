package com.shop.site.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/login", "/register").permitAll()
                        .anyRequest().authenticated()
                )

                .httpBasic(Customizer.withDefaults())
                .formLogin((formLogin) ->
                        formLogin
//                                .usernameParameter("username")
//                                .passwordParameter("password")
                                .loginPage("/login").permitAll()
                                .defaultSuccessUrl("/cart")
                                //.failureUrl("/register?failure")
                                //.loginProcessingUrl("/ authentication/ login/ process")



                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }

}