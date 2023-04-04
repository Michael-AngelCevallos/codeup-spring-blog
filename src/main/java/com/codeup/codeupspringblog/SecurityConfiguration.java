package com.codeup.codeupspringblog;

import com.codeup.codeupspringblog.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }




    //May HAVE TO CUSTOMIZE THIS CODE
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                /* Login configuration */
                .formLogin()
                .loginPage("/login") // the url that is typed in
                .defaultSuccessUrl("/posts1") // user's home page, it can be any URL ( where the user is re-directed once logged in)
                .permitAll() // Anyone can go to the login page


                /* Logout configuration */
                .and()
                .logout()
                .logoutSuccessUrl("/") // append a query string value


                /* Pages that can be viewed without having to log in */
                //gives a list of end points ad what to do with them
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/", "/posts1", "/posts/{id}", "/sign-up", "/login") // anyone can see home, the ads pages, and sign up
                .permitAll()  // allows everyone to come to these end points

                /* Pages that require authentication */
                .and()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/posts1/create", // only authenticated users can create ads
                        "/posts1/{id}/edit" // only authenticated users can edit ads
                )
                .authenticated(); // allows user to go to these end points as long as they are logged in

        return http.build();
    }

}
