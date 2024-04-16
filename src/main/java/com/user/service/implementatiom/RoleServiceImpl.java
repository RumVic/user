package com.user.service.implementatiom;

import com.user.builder.RoleBuilder;
import com.user.dao.entity.Role;
import com.user.dao.repository.RoleDao;
import com.user.dto.input.RoleDto;
import com.user.dto.output.RoleDtoOut;
import com.user.service.RoleService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao ;

    @Qualifier("appLogger")
    private final Logger logger;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao, Logger logger) {
        this.roleDao = roleDao;
        this.logger = logger;
    }

    @Override
    public Role create(RoleDto dto) {
        Role role = RoleBuilder.builder(dto);
        return roleDao.save(role);
    }

    @Override
    public void delete(UUID uuid) {
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
    public RoleDtoOut readById(UUID id) {
        return null;
    }
}
