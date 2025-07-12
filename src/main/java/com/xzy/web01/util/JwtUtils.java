package com.xzy.web01.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class JwtUtils {

    private static final String JWT_SECRET = "xzy";
    private static final String JWT_SECRET_b64 = Base64.getEncoder().encodeToString(JWT_SECRET.getBytes());
    private static final long JWT_TTL = 1000 * 60 * 60 * 24;

    // 生成Jwt令牌，全部参数自己控制
    public static String createJwt(Map<String, Object> claims, long ttlMillis) {
        return Jwts.builder()
                .addClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ttlMillis))
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET_b64)
                .compact();
    }

    // 生成jwt令牌，默认过期时间为24小时
    public static String createJwt(Map<String, Object> claims) {
        return createJwt(claims, JWT_TTL);
    }

    // 解析令牌
    public static Map<String, Object> parseJwt(String jwt) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET_b64)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
