package com.marticles.airnet.zuul.gateway.util;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.marticles.airnet.zuul.gateway.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author Marticles
 * @description JwtUtil
 * @date 2019/2/1
 */
@Slf4j
public class JwtUtil {
    public static final String SECRET = "AirNet";

    public static User getUserInfoByJwt(String token) {
        User user = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET))
                    .withIssuer("AirNet")
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> claims = jwt.getClaims();
            Claim claim = claims.get("user");
            user = JSON.parseObject(claim.asString(), User.class);
        } catch (JWTVerificationException exception) {
            log.error(exception.getMessage());
            throw new IllegalStateException("Invalid Token. " + exception.getMessage());
        }
        return user;
    }
}
