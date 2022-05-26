package com.godeltech.facade.impl;

import com.godeltech.facade.RoleFacade;
import com.godeltech.mapper.RoleMapper;
import com.godeltech.persistence.model.Role;
import com.godeltech.service.RoleService;
import com.godeltech.web.dto.request.RoleRequestDto;
import com.godeltech.web.dto.response.RoleResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class RoleFacadeImpl implements RoleFacade {
    private final RoleService roleService;
    private final RoleMapper roleMapper;
    @Override
    public RoleResponseDto findById(final Long id) {
        log.debug("Find role with id:{}", id);
        return roleMapper.toRoleResponseDto(roleService.findById(id));
    }

    @Override
    public List<RoleResponseDto> findAll() {
        log.debug("Find all roles");
        return roleMapper.toRoleResponseDtoList(roleService.findAll());
    }

    @Override
    public RoleResponseDto save(RoleRequestDto roleRequestDto) {
        log.debug("Save role");
        return roleMapper.toRoleResponseDto(roleService.save(roleMapper.toRole(roleRequestDto)));
    }
    
    @Override
    public void deleteById(final Long id) {
        log.debug("Delete role with id:{}", id);
        roleService.deleteById(id);
    }

    @Override
    public RoleResponseDto update(Long id, RoleRequestDto roleRequestDto) {
        log.debug("Update role with id:{}", id);
        final Role role = roleService.findById(id);
        roleMapper.updateEntity(role, roleRequestDto);
        return roleMapper.toRoleResponseDto(roleService.update(role));
    }
}
