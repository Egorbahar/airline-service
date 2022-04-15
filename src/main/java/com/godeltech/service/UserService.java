package com.godeltech.service;

import com.godeltech.persistence.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    User save(User user);

    List<User> findAll();

    User update(User user);

    void deleteById(Long id);
}
