package com.hybrid.hybridhavenapi.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
public class GithubTokenAuthentication extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "*");
            response.setStatus(HttpStatus.OK.value());
            return;
        }

        if (isPublic(requestURI)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = extractToken(request);
        if (StringUtils.hasText(token)) {
            if (isValidToken(token)) {
                filterChain.doFilter(request, response);
                return;
            }
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public String generateToken(String code) {
        RestTemplate restTemplate = new RestTemplate();
        String client_id = System.getenv("CLIENT_ID");
        String client_secret = System.getenv("CLIENT_SECRET");

        String url = String.format("https://github.com/login/oauth/access_token?client_id=%s&client_secret=%s&code=%s", client_id, client_secret, code);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        return getTokenFromResponse(response);
    }

    private String getTokenFromResponse(ResponseEntity<String> response) {
        String reponseString = response.getBody();
        if (reponseString != null) {

            if (reponseString.contains("error"))
                return reponseString;

            String[] arr = reponseString.split("&");

            for (String i : arr) {
                if (i.contains("access_token")) {
                    String[] j = i.split("=");
                    return j[1];
                }
            }
        }
        return reponseString;
    }

    private boolean isValidToken(String token) {
        try {
            String response = RestClient.create().get()
                    .uri("https://api.github.com/user")
                    .header("Authorization", "Bearer " + token)
                    .retrieve()
                    .body(String.class);
            if (response == null || response.trim().isEmpty()) return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isPublic(String url) {
        return Objects.equals(url, "/auth/code") || Objects.equals(url, "/");
    }
}