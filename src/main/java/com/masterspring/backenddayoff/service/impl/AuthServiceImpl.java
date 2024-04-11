package com.masterspring.backenddayoff.service.impl;

import com.masterspring.backenddayoff.dto.request.AuthRequest;
import com.masterspring.backenddayoff.dto.response.AuthResponse;
import com.masterspring.backenddayoff.entity.LeaveRemain;
import com.masterspring.backenddayoff.exception.AppException;
import com.masterspring.backenddayoff.repository.LeaveRemainRepository;
import com.masterspring.backenddayoff.repository.UserRepository;
import com.masterspring.backenddayoff.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final LeaveRemainRepository leaveRemainRepository;

    public AuthServiceImpl(UserRepository userRepository, LeaveRemainRepository leaveRemainRepository) {
        this.userRepository = userRepository;
        this.leaveRemainRepository = leaveRemainRepository;
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        var user = userRepository.findByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword());
        if (user == null) throw new AppException(HttpStatus.BAD_REQUEST.value(), "Invalid email or password");
        var authResponse = new AuthResponse();
        // Implement mapper
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

        checkRemainDays(user.getLeaveRemain());

        return authResponse;
    }

    private void checkRemainDays(LeaveRemain leaveRemain) {
        if (LocalDateTime.now().getYear() > leaveRemain.getYear()) {
            leaveRemainRepository.findById(leaveRemain.getId()).ifPresent(remain -> {
                remain.setYear(remain.getYear() + 1);
                remain.setRemainDays(remain.getRemainDays() + 1);
            });
        }
    }
}
