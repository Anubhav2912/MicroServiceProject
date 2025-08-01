package com.project.gateway.controllers;

import com.project.gateway.models.AuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client) { // Keep OAuth2AuthorizedClient if needed for other logic

        return ReactiveSecurityContextHolder.getContext()
                .map(securityContext -> {
                    Authentication authentication = securityContext.getAuthentication();
                    OidcUser user = (OidcUser) authentication.getPrincipal();
                    Model model;
                    logger.info("User email ID: {}", user.getEmail());
                    AuthResponse authResponse = new AuthResponse();
                    authResponse.setUserId(user.getEmail());
                    authResponse.setAccessToken(client.getAccessToken().getTokenValue());
                    authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());
                    authResponse.setExpiresAt(client.getAccessToken().getExpiresAt().getEpochSecond());
                    List<String> authorities = user.getAuthorities().stream().map(grantedAuthority -> {
                        return grantedAuthority.getAuthority();
                    }).collect(Collectors.toList());
                    authResponse.setAuthorities(authorities);
                    return new ResponseEntity<>(authResponse, HttpStatus.OK);
                });
    }
}
