package com.godeltech.service;

import com.godeltech.persistence.model.User;

import java.util.List;

public interface UserService {
    User findById(final Long id);

    User findByUserName(final String username);

    User save(final User user);

    List<User> findAll();

    User update(final User user);

    void deleteById(final Long id);

    User findByUsernameAndPassword(String username, String password);
}
