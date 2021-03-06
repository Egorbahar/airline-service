package com.godeltech.web.controller;

import com.godeltech.config.jwt.JwtProvider;
import com.godeltech.persistence.model.User;
import com.godeltech.service.UserService;
import com.godeltech.web.dto.request.AuthorizationRequestDto;
import com.godeltech.web.dto.response.AuthorizationResponseDto;
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

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
public class AuthorizationController {
    private final UserService userService;
    private final JwtProvider jwtProvider;

    @PostMapping("/auth")
    public ResponseEntity<AuthorizationResponseDto> auth(@RequestBody @Validated AuthorizationRequestDto authorizationRequestDto) {
        log.info("Auth contr");
        User user = userService.findByUsernameAndPassword(authorizationRequestDto.getUsername(), authorizationRequestDto.getPassword());
        String token = jwtProvider.generateToken(user.getUsername());
        return ResponseEntity.ok(new AuthorizationResponseDto(token, user.getRole().getName(), user.getId()));
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