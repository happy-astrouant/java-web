package com.xzy.web01.interceptor;

import com.xzy.web01.util.CurrentHolder;
import com.xzy.web01.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;


@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        if(url.contains("/login")){
            return true;
        }

        // 校验token
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            log.warn("token is empty");
            response.setStatus(401);
            return false;
        }

        Map<String, Object> claims = null;
        try {
            claims = JwtUtils.parseJwt(token);
        } catch (Exception e) {
            log.warn("token is invalid");
            response.setStatus(401);
            return false;
        }

        CurrentHolder.setTokenClaimsHolder(claims);

        if (claims == null) {
            log.warn("token is invalid");
            response.setStatus(401);
            return false;
        }

        log.info("user visit successfully. user info: {}", claims);

        // permit
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        CurrentHolder.removeTokenClaimsHolder();
    }
}
