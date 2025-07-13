package com.xzy.web01.filter;

import com.xzy.web01.util.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;


// 只放行登陆请求
//@WebFilter(urlPatterns = "/*")
@Slf4j
public class TokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        log.info("enter token filter method doFilter");

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURI();
        if(url.contains("/login")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 校验token
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            log.warn("token is empty");
            response.setStatus(401);
            return;
        }

        Map<String, Object> claims = null;
        try {
            claims = JwtUtils.parseJwt(token);
        } catch (Exception e) {
            log.warn("token is invalid");
            response.setStatus(401);
            return;
        }

        if (claims == null) {
            log.warn("token is invalid");
            response.setStatus(401);
            return;
        }

        log.info("user visit successfully. user info: {}", claims);

        // permit
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
