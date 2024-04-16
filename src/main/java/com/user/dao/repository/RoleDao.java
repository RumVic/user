package com.user.dao.repository;

import com.user.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleDao extends JpaRepository<Role, UUID> {
}
