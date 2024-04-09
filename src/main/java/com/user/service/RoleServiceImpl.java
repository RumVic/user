package com.user.service;

import com.user.dao.Role;
import com.user.dao.RoleDao;
import com.user.dto.RoleDto;
import com.user.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao ;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role create(RoleDto dto) {
        Role role = Role.builder().id(dto.getId()).role(dto.getRole()).build();
        return roleDao.save(role);
    }

    @Override
    public Role updateWithEntity(UUID id, Role role) {
        return null;
    }

    @Override
    public List<Role> read() {
        return null;
    }

    @Override
    public Role update(UUID id,RoleDto roleDto) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {
    }

    @Override
    public Role readById(UUID id) {
        return null;
    }
}
