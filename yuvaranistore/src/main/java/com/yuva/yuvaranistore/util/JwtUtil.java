package com.yuva.yuvaranistore.util;

import java.nio.charset.StandardCharsets;

import java.util.Base64;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;

import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.yuva.yuvaranistore.constants.ApplicationConstants;
import com.yuva.yuvaranistore.entity.Customer;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private final Environment env;

    public JwtUtil(Environment env) {
        this.env = env;
    }
    public String generateJwtToken(Authentication authentication){
        String jwt = "";
//        SecretKey key = Jwts.SIG.HS256.key().build();
//        String secretString = Base64.getEncoder().encodeToString(key.getEncoded());
        String secret = env.getProperty(ApplicationConstants.JWT_SECRET_KEY,
                ApplicationConstants.JWT_SECRET_DEFAULT_VALUE);
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        Customer fetchedCustomer = (Customer) authentication.getPrincipal();
        jwt = Jwts.builder().issuer("Eazy Store").subject("JWT Token")
                .claim("username", fetchedCustomer.getName())
                .claim("email", fetchedCustomer.getEmail())
                .claim("mobileNumber", fetchedCustomer.getMobileNumber())
                .claim("roles", authentication.getAuthorities().stream().map(
                        GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                .issuedAt(new java.util.Date())
                .expiration(new java.util.Date((new java.util.Date()).getTime() + 60 * 60 * 1000))
                .signWith(secretKey).compact();
        return jwt;
    }
}
