package com.masterspring.backenddayoff.service;

import com.masterspring.backenddayoff.dto.LeaveRequestDto;

public interface LeaveRequestService {
    public LeaveRequestDto confirmLeaveRequest(Long id, LeaveRequestDto leaveRequestDto);
}
