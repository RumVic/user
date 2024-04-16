package com.user;

import com.user.dao.entity.Role;
import com.user.dao.repository.RoleDao;
import com.user.dto.input.RoleDto;
import com.user.service.implementatiom.RoleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleDao roleDao;

    @InjectMocks
    private RoleServiceImpl roleService;

    @Test
    public void testCreateRole() {
        UUID roleId = UUID.randomUUID();
        String roleName = "user";
        RoleDto roleDto = new RoleDto(roleId, roleName);
        Role role = Role.builder().id(roleId).role(roleName).build();
        when(roleDao.save(any(Role.class))).thenReturn(role);
        Role createdRole = roleService.create(roleDto);

        assertAll(
                () -> assertEquals(roleId, createdRole.getId()),
                () -> assertEquals(roleName, createdRole.getRole()),
                () -> verify(roleDao).save(any(Role.class))
        );
    }
}
