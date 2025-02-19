package com.example.autobaza.configuration;


import org.springframework.stereotype.Component;

import org.springframework.security.core.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import java.io.IOException;

@Component
public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    private static final String realName = "app_user";

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName(realName);
        super.afterPropertiesSet();
    }

}
