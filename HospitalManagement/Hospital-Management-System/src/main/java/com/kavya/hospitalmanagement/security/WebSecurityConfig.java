package com.kavya.hospitalmanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;


@Configuration // this tells spring that this class contains the bean method which should be
               // created and managed in the spring container and later injected wherever
               // required
@RequiredArgsConstructor
public class WebSecurityConfig {
        
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        .csrf(csrfConfig -> csrfConfig.disable())
        .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))       // now the session is not stored in the server and the client has to send the token in every request to authenticate itself
        .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**", "/auth/**").permitAll() // now all the public endpoints will be accessible without
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
        );
                // .formLogin(Customizer.withDefaults());  reason for removing this is because we are using jwt token based authentication and form login is not required in this case and also we will be using postman to test the api's so form login is not required in this case... or may be we'll be using some different custom made login form...
        return httpSecurity.build();
    }

//     // @Bean
//     public UserDetailsService userDetailsService() {
//         UserDetails user1 = User.withUsername("admin")
//                 .roles("ADMIN")
//                 .password(passwordEncoder.encode("pass"))
//                 .build(); // now the password will be stored in encoded format in the memory and when the
//                           // user tries to login then the password will be encoded and compared with the
//                           // stored password

//         UserDetails user2 = User.withUsername("user2")
//                 .roles("GENERAL")
//                 .password(passwordEncoder.encode("user2"))
//                 .build();
//         return new InMemoryUserDetailsManager(user1, user2);
//     }
}
