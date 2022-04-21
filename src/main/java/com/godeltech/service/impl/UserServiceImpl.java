package com.godeltech.service.impl;

import com.godeltech.component.LocalMessageSource;
import com.godeltech.exception.ResourceNotFoundException;
import com.godeltech.persistence.model.User;
import com.godeltech.persistence.repository.RoleRepository;
import com.godeltech.persistence.repository.UserRepository;
import com.godeltech.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LocalMessageSource messageSource;

    @Override
    public User findById(final Long id) {
        log.debug("Find user with id:{}", id);
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(messageSource.getMessage("error.user.notExist", new Object[]{})));
    }

    @Override
    public User findByUserName(final String username) {
        log.debug("Find user by username:{}", username);
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException(messageSource.getMessage("error.credentials.notValid", new Object[]{})));
    }

    @Override
    @Transactional
    public User save(final User user) {
        log.debug("Save new user");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        log.debug("Find all users");
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User update(final User user) {
        log.debug("Update user with id:{}", user.getId());
        findById(user.getId());
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        log.debug("Delete user with id:{}", id);
        findById(id);
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        log.debug("Find user by username and password");
        User user = findByUserName(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new ResourceNotFoundException(messageSource.getMessage("error.credentials.notValid", new Object[]{}));
        }
        return user;
    }
}
