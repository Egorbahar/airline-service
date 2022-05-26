package com.godeltech.web.controller;

import com.godeltech.config.jwt.JwtProvider;
import com.godeltech.exception.TokenRefreshException;
import com.godeltech.persistence.model.RefreshToken;
import com.godeltech.persistence.model.User;
import com.godeltech.service.RefreshTokenService;
import com.godeltech.service.UserService;
import com.godeltech.web.dto.request.AuthorizationRequestDto;
import com.godeltech.web.dto.request.TokenRefreshRequestDto;
import com.godeltech.web.dto.response.AuthorizationResponseDto;
import com.godeltech.web.dto.response.TokenRefreshResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
public class AuthorizationController {
    private final UserService userService;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/auth")
    public ResponseEntity<AuthorizationResponseDto> auth(@RequestBody @Validated AuthorizationRequestDto authorizationRequestDto) {
        log.info("Auth contr");
        User user = userService.findByUsernameAndPassword(authorizationRequestDto.getUsername(), authorizationRequestDto.getPassword());
        String token = jwtProvider.generateToken(user.getUsername());
        return ResponseEntity.ok(new AuthorizationResponseDto(token, user.getRole().getName(), user.getId()));
    }

    @PostMapping("/auth/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody @Validated TokenRefreshRequestDto tokenRefreshRequestDto) {
        String requestRefreshToken = tokenRefreshRequestDto.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtProvider.generateToken(user.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponseDto(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }

    @RequestMapping(value = "/sign-out", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}