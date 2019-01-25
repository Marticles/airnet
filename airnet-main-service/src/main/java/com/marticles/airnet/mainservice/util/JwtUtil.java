package com.marticles.airnet.mainservice.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.marticles.airnet.mainservice.model.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marticles
 * @description JwtUtil
 * @date 2019/1/23
 */
public class JwtUtil {
    public static final String SECRET = "AirNet";

    public static String generateJwt(User user) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("typ", "JWT");
        map.put("alg", "HS256");
        String userJson = JSONObject.toJSONString(user);
        String jwt = JWT.create()
                .withHeader(map)
                .withClaim("user",userJson)
                .withIssuer("AirNet")
                .withAudience(user.getName())
                .withIssuedAt(new Date())
                .sign(algorithm);
        return jwt;
    }

    public static User getUserInfoByJwt(String token) {
        User user = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("AirNet")
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> claims = jwt.getClaims();
            Claim claim = claims.get("user");
            user = JSON.parseObject(claim.asString(), User.class);
        } catch (JWTVerificationException exception) {
            throw new IllegalStateException("Invalid Token. " + exception.getMessage());
        }
        return user;
    }

}
