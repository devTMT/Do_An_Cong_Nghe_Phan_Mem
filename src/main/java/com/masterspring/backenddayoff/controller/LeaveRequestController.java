package com.masterspring.backenddayoff.controller;

import com.masterspring.backenddayoff.dto.response.LeaveHistory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/leave")
public class LeaveRequestController {

    @GetMapping
    public ResponseEntity<LeaveHistory> getLeaveHistory() {
        var leaveHistory = new LeaveHistory();

        return ResponseEntity.ok(leaveHistory);
    }
}
