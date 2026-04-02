package com.kavya.hospitalmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // this tells spring that this class contains the bean method which should be
               // created and managed in the spring container and later injected wherever
               // required
public class WebSecurityConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll() // now all the public endpoints will be accessible without
                                                           // authentication
                // .requestMatchers("/admin/**").authenticated() but the admin endpoints will
                // require authentication... this checks whether the request is authenticated or
                // not, if not then it will redirect to the login page
                .requestMatchers("/admin/**").hasRole("ADMIN") // now this will check whether the user has the role of
                                                               // admin or not, if not then it will return 403 forbidden
                                                               // error
                .requestMatchers("/general/**").hasAnyRole("DOCTOR", "ADMIN","GENERAL")
                // this req will be accessible to both doctor and admin
                .anyRequest().authenticated() // if none of the above matchers match then it will require authentication
        )
                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("admin")
                .roles("ADMIN")
                .password(passwordEncoder.encode("pass"))
                .build(); // now the password will be stored in encoded format in the memory and when the
                          // user tries to login then the password will be encoded and compared with the
                          // stored password

        UserDetails user2 = User.withUsername("user2")
                .roles("GENERAL")
                .password(passwordEncoder.encode("user2"))
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
}
