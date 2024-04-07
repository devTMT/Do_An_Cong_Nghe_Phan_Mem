package com.masterspring.backenddayoff.dto.response;

import com.masterspring.backenddayoff.entity.Department;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthResponse {

    private Long id;

    @Email
    private String email;

    private String fullName;

    private LocalDateTime birthDate;

    private LocalDateTime workDate;

    private String phone;

    private String address;

    private String role;

    private Department department;

    private Integer remainDays;
}
