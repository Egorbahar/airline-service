package com.godeltech.service.impl;

import com.godeltech.exception.TokenRefreshException;
import com.godeltech.persistence.model.RefreshToken;
import com.godeltech.persistence.repository.RefreshTokenRepository;
import com.godeltech.persistence.repository.UserRepository;
import com.godeltech.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class RefreshTokenServiceImpl implements RefreshTokenService {
    @Value("${jwt.refreshExpirationMs}")
    private Long refreshTokenDurationMs;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    @Override
    public Optional<RefreshToken> findByToken(final String token) {
        log.debug("Find refresh token by token:{}", token);
        return refreshTokenRepository.findByToken(token);
    }

    @Override
    @Transactional
    public RefreshToken createRefreshToken(final Long userId) {
        log.debug("Create refresh token for user with id:{}",userId);
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(userRepository.findById(userId).get());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    @Override
    @Transactional
    public RefreshToken verifyExpiration(RefreshToken refreshToken) {
        log.debug("Verify refresh token");
        if (refreshToken.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(refreshToken);
            throw new TokenRefreshException(refreshToken.getToken(), "Refresh token was expired. Please make a new sign in request");
        }
        return refreshToken;
    }

    @Override
    @Transactional
    public void deleteByUserId(final Long userId) {
        log.debug("Delete refresh token by user id:{}",userId);
        refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
    }
}

