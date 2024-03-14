package com.tobeto.service;

import com.tobeto.entity.Role;
import com.tobeto.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TokenService {
    @Value("${application.security.jwt.SECRET_KEY}")
    private String KEY;

    public String createToken(User user) {
        JwtBuilder builder = Jwts.builder();
        List<Role> usersRole = (List<Role>) user.getRole();

        String[] roles = new String[usersRole.size()];
        for (int i = 0; i < usersRole.size(); i++) {
            roles[i] = usersRole.get(i).getRole();
        }

        // add custom keys
        Map<String, Object> customKeys = new HashMap<>();
        customKeys.put("roles", roles);
        customKeys.put("userId", user.getId().toString());
        builder = builder.claims(customKeys);
        Instant tarih = Instant.now().plus(15, ChronoUnit.MINUTES);

        builder = builder.subject("login").id(user.getEmail()).issuedAt(new Date()).expiration(Date.from(tarih));

        return builder.signWith(getKey()).compact();
    }

    public Claims tokenKontrol(String token) {
        JwtParser builder = Jwts.parser().verifyWith(getKey()).build();
        return builder.parseSignedClaims(token).getPayload();
    }

    private SecretKey getKey() {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(KEY));
        return key;
    }
}