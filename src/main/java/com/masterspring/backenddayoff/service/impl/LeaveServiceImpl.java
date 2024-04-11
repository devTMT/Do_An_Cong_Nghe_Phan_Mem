package com.masterspring.backenddayoff.service.impl;

import com.masterspring.backenddayoff.dto.response.LeaveResponse;
import com.masterspring.backenddayoff.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveServiceImpl(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    public List<LeaveResponse> getAllLeaveRequests() {
        return leaveRequestRepository.findAll().stream().map(leaveRequest -> {
            LeaveResponse leaveResponse = new LeaveResponse();
            leaveResponse.setId(leaveRequest.getId());
            leaveResponse.setDate(leaveRequest.getDate());
            leaveResponse.setStatus(leaveRequest.getStatus());
            leaveResponse.setReason(leaveRequest.getReason());
            return leaveResponse;
        }).toList();
    }
}
