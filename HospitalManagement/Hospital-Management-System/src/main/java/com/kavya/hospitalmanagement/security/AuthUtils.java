package com.kavya.hospitalmanagement.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kavya.hospitalmanagement.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class AuthUtils {

    @Value("${jwt.secretkey}")  // feild injection from the application properties file to get the secret key for jwt token generation and validation...
    private String JWT_SECRET_KEY;

    // it is the signature part of the jwt token which is used to sign the token and also to validate the token and it should be kept secret and should not be shared with anyone and it should be a long random string to make it more secure and it should be at least 256 bits long for HS256 algorithm which is the default algorithm used by jjwt library for signing the token...
    private SecretKey getSecretKey() {
        // this method will return the secret key for jwt token generation and validation...
        return Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));       // converts the raw bytes into ScretKey object attaches algorithmic info for compatibility, validates key strength, standardizes key format, and ensures secure handling of the key for JWT operations.
    }

    public String generateToken(User user) {
        // this method will generate the jwt token for the user and return it to the client...
        return Jwts.builder()
                    // payload 
                    .subject(user.getUsername())
                    .claim("userId", user.getId().toString())
                    .issuedAt(new Date())
                    .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10)) // these are excess token and they are short lived and expire within in 10-15 minutes after that the user must relogin... but if we want the token to be shortlived and also don't want user to relogin then make use of the refresh token....
                    .signWith(getSecretKey())  
                    .compact();
    }

    //  subject + claims + issuedAt --> payload 
    // .signWith(getSecretKey()) --> will give the secret key and the header will be autogeneraed by the jjwt library and it will contain the algorithm used for signing the token and the type of the token which is JWT and then the compact() method will generate the token in the form of string and return it to the client...


}
