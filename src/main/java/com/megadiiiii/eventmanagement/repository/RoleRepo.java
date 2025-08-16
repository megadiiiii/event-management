package com.megadiiiii.eventmanagement.repository;

import com.megadiiiii.eventmanagement.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
