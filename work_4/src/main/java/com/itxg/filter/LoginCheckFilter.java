package com.itxg.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itxg.result.Result;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class LoginCheckFilter implements Filter {

    private static final String VALID_TOKEN = "admin-token";

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestUri = request.getRequestURI();

        String contextPath = request.getContextPath();

        String path = requestUri.substring(contextPath.length());

        boolean needCheck = path.startsWith("/depts") || path.startsWith("/upload");

        if (!needCheck) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("token");

        if (VALID_TOKEN.equals(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        response.setStatus(401);
        response.setContentType("application/json;charset=utf-8");

        Result result = Result.unauthorized("未登录或 token 不正确");

        String json = new ObjectMapper().writeValueAsString(result);

        response.getWriter().write(json);
    }
}