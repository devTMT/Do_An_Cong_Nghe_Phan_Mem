package com.masterspring.backenddayoff.controller;

import com.masterspring.backenddayoff.dto.LeaveRequestDto;
import com.masterspring.backenddayoff.entity.LeaveRequest;
import com.masterspring.backenddayoff.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leave_request/")
public class LeaveRequestController {
    private LeaveRequestService leaveRequestService;

    @Autowired
    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @PutMapping("update_status/{id}")
    public ResponseEntity<LeaveRequestDto> updateStatus(
            @PathVariable("id") long id,
            @RequestBody LeaveRequestDto leaveRequestDto) {
        return ResponseEntity.ok(leaveRequestService.confirmLeaveRequest(id, leaveRequestDto));
    }
}
