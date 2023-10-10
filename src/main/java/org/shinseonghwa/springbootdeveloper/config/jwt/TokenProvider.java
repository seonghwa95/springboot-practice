package org.shinseonghwa.springbootdeveloper.config.jwt;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.shinseonghwa.springbootdeveloper.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class TokenProvider {

    private final JwtProperties jwtProperties;

    public String generateToken(User user, Duration expiredAt) {
        Date now = new Date();

        return "";
    }

    // JWT 토큰 생성 메서드
    private String makeToken(Date expiry, User user) {
        Date now = new Date();

        return "";
    }

    // JWT 토큰 유효성 검증 메서드
    public boolean validToken(String token) {
        try {

        } catch (IllegalStateException illegalStateException) {

        }

        return true;
    }

    // 토큰 기반으로 인증 정보를 가져오는 메서드
    public Authentication getAuthentication(String token) {
        Claims claims = get

        return ;
    }

    // 토큰 기반으로 유저 ID를 가져오는 메서드
    public Long getUserId(String token) {
        Claims claims =
    }

    private Claims getClaims(String token) {
        return
    }
}
