package com.masterspring.backenddayoff.controller;

import com.masterspring.backenddayoff.dto.LeaveRequestStatusDto;
import com.masterspring.backenddayoff.dto.response.LeaveRequestPaginationResponse;
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
    public ResponseEntity<LeaveRequestStatusDto> updateStatus(
            @PathVariable("id") long id,
            @RequestBody LeaveRequestStatusDto leaveRequestDto) {
        return ResponseEntity.ok(leaveRequestService.confirmLeaveRequest(id, leaveRequestDto));
    }

    @GetMapping("pagination_manager")
    public ResponseEntity<LeaveRequestPaginationResponse> getLeaveRequestsWithManagerId(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "2", required = false) int pageSize){
        return ResponseEntity.ok(leaveRequestService.getPageLeaveRequestsWithManagerId(pageNo, pageSize));
    }
}
