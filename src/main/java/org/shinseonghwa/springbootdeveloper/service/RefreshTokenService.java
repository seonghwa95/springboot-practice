package org.shinseonghwa.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.shinseonghwa.springbootdeveloper.domain.RefreshToken;
import org.shinseonghwa.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}
