package com.kavya.hospitalmanagement.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "app_users")
public class User implements UserDetails { // internally DaoAuthenticationProvider will use UserDetailsService to load
                                           // the user details and then compare the password with the one stored in the
                                           // database. If they match, the authentication is successful, and the user is
                                           // granted access to the application. But if we want to use our own user
                                           // details service then we have to implement the UserDetailsService interface
                                           // and override the loadUserByUsername method to load the user details from
                                           // the database. Then we have to configure the authentication manager to use
                                           // our custom user details service.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return java.util.List.of();
    }

    @Override
    public String getUsername() {
        return username;
    }

}

// But by default DAO AUTHENTICATION will use InMemoryUserDetailsManager for
// authentication as we're creating its bean in the websecurityconfig class. So
// we have to create a bean of our custom user details service and configure the
// authentication manager to use it. Then we can load the user details from the
// database and authenticate the user.
