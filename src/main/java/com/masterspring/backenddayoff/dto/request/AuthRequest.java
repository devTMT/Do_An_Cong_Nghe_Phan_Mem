package com.masterspring.backenddayoff.dto.request;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AuthRequest {
    @Email(message = "Invalid email format.")
    private String email;

    @Length(min = 8, message = "Password length must be at least 8 characters.")
    private String password;
}
