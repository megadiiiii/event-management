package com.megadiiiii.eventmanagement.repository;

import com.megadiiiii.eventmanagement.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);
}
