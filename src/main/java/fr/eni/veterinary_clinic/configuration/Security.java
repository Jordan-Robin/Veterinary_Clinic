package fr.eni.veterinary_clinic.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class Security {

    private static final String SELECT_USER =
            "SELECT mail AS username, password, active AS enabled FROM Staff WHERE mail = ?";
    private static final String SELECT_ROLES = "SELECT s.mail AS username, a.role AS authority FROM Staff s " +
            "INNER JOIN Staff_Authorities AS sa ON s.id = sa.staff_id " +
            "INNER JOIN Authorities AS a ON sa.role_id = a.id WHERE s.mail = ?;";

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(SELECT_USER);
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(SELECT_ROLES);

        return jdbcUserDetailsManager;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(requests -> {
                requests
                    .requestMatchers("/", "/login").permitAll() // Autoriser l'accès à la racine et à la page de login
                    .requestMatchers("/test/ok").permitAll()
                    .anyRequest().authenticated(); // Toutes les autres requêtes nécessitent une authentification
            })
            .formLogin(form -> {
                form
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/test/ok").permitAll();
            });

        return http.build();
    }


    /*
        @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(requests -> {
                    requests
                        .requestMatchers("/", "/login").permitAll() // Autoriser l'accès à la racine et à la page de login
                        .anyRequest().authenticated(); // Toutes les autres requêtes nécessitent une authentification
                })
                .formLogin((form) -> form
                        .loginPage("/login") // Spécifie une page de login personnalisée si nécessaire
                        .defaultSuccessUrl("/", false)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/")
                        .permitAll()
                );

        return http.build();
    }
     */

}
