package com.masterspring.backenddayoff.service.impl;

import com.masterspring.backenddayoff.dto.request.AuthRequest;
import com.masterspring.backenddayoff.entity.User;
import com.masterspring.backenddayoff.exception.AppException;
import com.masterspring.backenddayoff.repository.UserRepository;
import com.masterspring.backenddayoff.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(AuthRequest authRequest) {
        var user = userRepository.findByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword());
        if (user == null) throw new AppException(HttpStatus.BAD_REQUEST.value(), "Invalid email or password");
        return user;
    }
}
