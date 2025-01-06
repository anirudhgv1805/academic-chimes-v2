// package com.academicchimes.app.security;

// import java.security.Key;
// import java.util.Date;

// import javax.crypto.spec.SecretKeySpec;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.Jwts.SIG;



// @Component
// public class JwtUtil {

//     @Value("${jwt.secret}")
//     private String secretKey;
//     @Value("${jwt.ValidityInMS}")
//     private long validityInMilliSeconds;

//     public String generateToken(String userId,String role){
//         Key key = new SecretKeyS;
//         return Jwts.builder()
//                 .subject(userId)
//                 .claim("role", role)
//                 .issuedAt(new Date())
//                 .expiration(new Date(System.currentTimeMillis() + validityInMilliSeconds))
//                 .signWith(secretKey)
//                 .compact();
//     }
// }
