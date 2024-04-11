package com.masterspring.backenddayoff.controller;

import com.masterspring.backenddayoff.dto.response.LeaveResponse;
import com.masterspring.backenddayoff.repository.LeaveRequestRepository;
import com.masterspring.backenddayoff.service.impl.LeaveServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leave")
public class LeaveRequestController {

    private final LeaveRequestRepository leaveRequestRepository;
    private final LeaveServiceImpl leaveServiceImpl;

    public LeaveRequestController(LeaveRequestRepository leaveRequestRepository, LeaveServiceImpl leaveServiceImpl) {
        this.leaveRequestRepository = leaveRequestRepository;
        this.leaveServiceImpl = leaveServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<LeaveResponse>> getLeaveHistory() {
        var leaveHistory = leaveServiceImpl.getAllLeaveRequests();
        return new ResponseEntity<>(leaveHistory, HttpStatus.OK);
    }
}
