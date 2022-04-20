package com.godeltech.service.impl;

import com.godeltech.persistence.model.User;
import com.godeltech.persistence.repository.RoleRepository;
import com.godeltech.persistence.repository.UserRepository;
import com.godeltech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findById(final Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User findByUserName(final String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public User save(final User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(final User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteById(final Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        User user = findByUserName(userName);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null; //write exception
    }


}
