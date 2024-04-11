package com.masterspring.backenddayoff.service;

import com.masterspring.backenddayoff.dto.LeaveRequestStatusDto;
import com.masterspring.backenddayoff.dto.response.LeaveRequestPaginationResponse;

public interface LeaveRequestService {
    LeaveRequestStatusDto confirmLeaveRequest(Long id, LeaveRequestStatusDto leaveRequestDto);
    LeaveRequestPaginationResponse getPageLeaveRequests(int pageNo, int pageSize);
    LeaveRequestPaginationResponse getPageLeaveRequestsWithUserId(Long userId, Integer pageNo, Integer pageSize);
    LeaveRequestPaginationResponse getPageLeaveRequestsBySearch(String keyword, Integer pageNo, Integer pageSize);

}
