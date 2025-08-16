package com.megadiiiii.eventmanagement.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    @NotBlank(message="Name is not null")
    private String name;
    @NotBlank(message="Email is not null")
    private String email;
    @NotBlank(message="Password is not null")
    private String password;
}
