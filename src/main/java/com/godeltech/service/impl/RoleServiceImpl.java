package com.godeltech.service.impl;

import com.godeltech.component.LocalMessageSource;
import com.godeltech.exception.ResourceNotFoundException;
import com.godeltech.persistence.model.Role;
import com.godeltech.persistence.repository.RoleRepository;
import com.godeltech.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final LocalMessageSource messageSource;

    @Override
    public Role findById(final Long id) {
        log.debug("Find role with id:{}", id);
        return roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(messageSource.getMessage("error.record.notExist", new Object[]{})));
    }

    @Override
    @Transactional
    public Role save(final Role role) {
        log.debug("Save new role");
        return roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        log.debug("Find all roles");
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public Role update(final Role role) {
        log.debug("Update role with id:{}", role.getId());
        findById(role.getId());
        return roleRepository.saveAndFlush(role);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        log.debug("Delete role with id:{}", id);
        findById(id);
        roleRepository.deleteById(id);
    }
}
