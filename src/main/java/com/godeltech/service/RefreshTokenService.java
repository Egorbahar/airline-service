package com.godeltech.service;

import com.godeltech.persistence.model.RefreshToken;

import javax.transaction.Transactional;
import java.util.Optional;

public interface RefreshTokenService {
    Optional<RefreshToken> findByToken(String token);

    RefreshToken createRefreshToken(Long userId);

    RefreshToken verifyExpiration(RefreshToken token);

    @Transactional
    void deleteByUserId(Long userId);
}
