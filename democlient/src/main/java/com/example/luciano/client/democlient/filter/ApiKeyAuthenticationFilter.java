package com.example.luciano.client.democlient.filter;

import com.example.luciano.client.democlient.authentication.service.ApiKeyCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApiKeyAuthenticationFilter  extends GenericFilterBean {


    @Autowired
    private ApiKeyCredentialsService apiKeyCredentialsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ApiKeyAuthenticationFilter() {
        super();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        super.doFilter(req, res, chain);
        Authentication apiKeyAuthorizationToken = apiKeyCredentialsService.getAuthentication();
        SecurityContextHolder.getContext().setAuthentication(apiKeyAuthorizationToken);
        Authentication tokenAuthentication = authenticationManager.authenticate(apiKeyAuthorizationToken);
        if (tokenAuthentication != null) {
            SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
            chain.doFilter(req, res);
        } else {
            throw new UnauthorizedException("Nao autorizado!!");
        }
    }


//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
//        Authentication apiKeyAuthorizationToken = apiKeyCredentialsService.getAuthentication();
//        SecurityContextHolder.getContext().setAuthentication(apiKeyAuthorizationToken);
//        return this.getAuthenticationManager().authenticate(apiKeyAuthorizationToken);
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        super.successfulAuthentication(request, response, chain, authResult);
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
//        super.unsuccessfulAuthentication(request, response, new UnauthorizedException("Nao autorizado"));
//    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    private class UnauthorizedException extends AuthenticationException {
        public UnauthorizedException(String msg) {
            super(msg);
        }
    }

//    @Override
//    @Autowired
//    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
//        super.setAuthenticationManager(authenticationManager);
//    }
}
