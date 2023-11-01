package org.shinseonghwa.springbootdeveloper.config.oauth;

import lombok.RequiredArgsConstructor;
import org.shinseonghwa.springbootdeveloper.config.jwt.TokenProvider;
import org.shinseonghwa.springbootdeveloper.repository.RefreshTokenRepository;
import org.shinseonghwa.springbootdeveloper.service.UserService;

@RequiredArgsConstructor
public class OAuth2SuccessHandler {
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final OAuth2AuthorizationRequestBasedOnCookieRepository authorizationRequestRepository;
    private final UserService userService;


}
