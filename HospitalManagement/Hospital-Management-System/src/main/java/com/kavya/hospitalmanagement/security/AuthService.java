package com.kavya.hospitalmanagement.security;

import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kavya.hospitalmanagement.dto.LoginRequestDTO;
import com.kavya.hospitalmanagement.dto.LoginResponseDTO;
import com.kavya.hospitalmanagement.dto.SignUpRequestDTO;
import com.kavya.hospitalmanagement.dto.SignUpResponseDTO;
import com.kavya.hospitalmanagement.entity.User;
import com.kavya.hospitalmanagement.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtils authUtils;
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;

    public LoginResponseDTO Login(LoginRequestDTO loginRequestDTO) {
        // all the login request will be delegated to the authentication manager and the
        // authentication manager will authenticate the user and if the authentication
        // is successful then it will return the jwt token and the user id in the
        // response...

        Authentication authentication = authenticationManager.authenticate(
                // since we want username password based login we will use the
                // UsernamePasswordAuthenticationToken to authenticate the user...
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
        // if the authentication is successful then get the user ..
        User user = (User) authentication.getPrincipal();

        // creating the token for the user and returning the response...
        String token = authUtils.generateToken(user);
        return new LoginResponseDTO(token, user.getId());
    }

    public SignUpResponseDTO signup(SignUpRequestDTO signUpRequest) {
        User user = userRepo.findByUsername(signUpRequest.getUsername()).orElse(null);  // first check whether the user exist in the db or not if exist then return the response with the message user already exist and if not exist then create a new user and save it to the db and return the response with the message user created successfully...

        if(user != null){
            throw new IllegalArgumentException("User already exists");
        }
        User newUser = userRepo.save(User.builder()
                                .username(signUpRequest.getUsername())
                                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                                .build());
        return mapper.map(newUser, SignUpResponseDTO.class);
    }

}
