package com.masterspring.backenddayoff.service.impl;

import com.masterspring.backenddayoff.dto.request.AuthRequest;
import com.masterspring.backenddayoff.dto.response.AuthResponse;
import com.masterspring.backenddayoff.exception.AppException;
import com.masterspring.backenddayoff.repository.UserRepository;
import com.masterspring.backenddayoff.service.AuthService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        var user = userRepository.findByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword());
        if (user == null) throw new AppException(HttpStatus.BAD_REQUEST.value(), "Invalid email or password");
        var authResponse = new AuthResponse();
        authResponse.setEmail(user.getEmail());
        authResponse.setAddress(user.getAddress());
        authResponse.setDepartment(user.getDepartment());
        authResponse.setBirthDate(user.getBirthDate());
        authResponse.setWorkDate(user.getWorkDate());
        authResponse.setPhone(user.getPhone());
        authResponse.setFullName(user.getFullName());
        authResponse.setRole(user.getRole().name().toLowerCase());
        authResponse.setId(user.getId());
        authResponse.setRemainDays(user.getLeaveRemain().getRemainDays());

        return authResponse;
    }
}
