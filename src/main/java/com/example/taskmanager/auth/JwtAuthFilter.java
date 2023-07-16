package com.example.taskmanager.auth;

import com.example.taskmanager.repository.UserRepository;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

          private final UserRepository userRepository;
           private final JwtService jwtService;
           private final UserDetailsService userDetailsService;

    //  private final CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

    @Override
    protected void doFilterInternal( @NonNull HttpServletRequest request,
                                     @NonNull HttpServletResponse response,
                                     @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");//
        final String email;
        final String jwt;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(7);
        email = jwtService.extractUsername(jwt);
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {


            UserDetails customUserDetails =  this.userDetailsService.loadUserByUsername(email);


            if (jwtService.isTokenValid(jwt, customUserDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        customUserDetails,
                        null,
                        customUserDetails.getAuthorities()
                );

                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                    SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);

    }

}
