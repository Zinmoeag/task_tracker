package com.taskTracker.tasks.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.taskTracker.tasks.user.application.services.UserService;

import org.springframework.http.HttpHeaders;


import java.io.IOException;

@Service
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
        final HttpServletRequest request,
        final HttpServletResponse response,
        final FilterChain filterChain) throws ServletException, IOException {
        System.out.println("JwtFilter");
        System.out.println(request.getHeader("Authorization"));

        
        // skip if auth endpoint
        if(request.getServletPath().contains("/api/v1/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        // get token from header
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwt;
        final String username;
        final String bearerPrefix = "Bearer ";

        // check if auth header is valid
        if(authHeader == null || !authHeader.startsWith(bearerPrefix)) {
            System.out.println("Auth header is null or does not start with bearer prefix");
            filterChain.doFilter(request, response);
            return;
        }
        
        jwt = authHeader.substring(bearerPrefix.length());
        username = this.jwtService.extractUsername(jwt);
        System.out.println("Username: " + username);
        System.out.println("Authentication: " + SecurityContextHolder.getContext().getAuthentication());

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            System.out.println("Username is null and authentication is null");
            final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if(this.jwtService.isTokenValid(jwt, userDetails.getUsername())) {
                System.out.println("Token is valid");
                final UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                System.out.println("Authentication token: " + authToken);
                System.out.println("Security context: " + SecurityContextHolder.getContext());
                SecurityContextHolder.getContext().setAuthentication(authToken);  
                System.out.println("Security context after set: " + SecurityContextHolder.getContext());
                System.out.println("Authentication set");
            }
        }

        filterChain.doFilter(request, response);
    }
}
