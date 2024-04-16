package com.user.dao.repository;

import com.user.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDao extends JpaRepository<User, UUID> {
    User findByEmail(String username);
}
