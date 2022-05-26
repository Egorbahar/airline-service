package com.godeltech.service;

import com.godeltech.persistence.model.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleService {
    Role findById(Long id);


    Role save(Role role);

    List<Role> findAll();


    Role update(Role role);

    void deleteById(Long id);
}
