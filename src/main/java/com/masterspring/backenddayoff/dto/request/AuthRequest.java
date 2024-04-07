package com.masterspring.backenddayoff.dto.request;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AuthRequest {
    @Email
    private String email;

    @Length(min = 8)
    private String password;
}
