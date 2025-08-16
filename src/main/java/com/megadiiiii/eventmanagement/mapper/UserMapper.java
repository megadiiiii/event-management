package com.megadiiiii.eventmanagement.mapper;

import com.megadiiiii.eventmanagement.dto.user.CreateUserDTO;
import com.megadiiiii.eventmanagement.dto.user.RoleDTO;
import com.megadiiiii.eventmanagement.dto.user.UpdateUserDTO;
import com.megadiiiii.eventmanagement.dto.user.UserDetailDTO;
import com.megadiiiii.eventmanagement.models.Role;
import com.megadiiiii.eventmanagement.models.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    CreateUserDTO toCreateUserDTO(UserEntity user);

    RoleDTO toRoleDTO(Role role);

    UpdateUserDTO toUpdateUserDTO(UserEntity user);

    UserDetailDTO toUserDetailDTO(UserEntity user);
}
