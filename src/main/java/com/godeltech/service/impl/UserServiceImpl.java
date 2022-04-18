package com.godeltech.service.impl;

import com.godeltech.persistence.model.User;
import com.godeltech.persistence.repository.UserRepository;
import com.godeltech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findById(final Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User save(final User user) {
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
}
