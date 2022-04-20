package com.godeltech.service;

import com.godeltech.persistence.model.User;

import java.util.List;

public interface UserService {
    User findById(final Long id);

    User findByUserName(final String userName);

    User save(final User user);

    List<User> findAll();

    User update(final User user);

    void deleteById(final Long id);

    User findByUserNameAndPassword(String userName, String password);
}
