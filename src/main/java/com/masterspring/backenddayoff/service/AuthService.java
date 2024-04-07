package com.masterspring.backenddayoff.service;

import com.masterspring.backenddayoff.dto.request.AuthRequest;
import com.masterspring.backenddayoff.entity.User;

public interface AuthService {
    User login(AuthRequest authRequest);
}
