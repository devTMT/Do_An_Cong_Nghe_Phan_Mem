package com.masterspring.backenddayoff.service;

import com.masterspring.backenddayoff.dto.LeaveRequestStatusDto;
import com.masterspring.backenddayoff.dto.response.LeaveRequestPaginationResponse;
import com.masterspring.backenddayoff.entity.LeaveRequest;
import org.springframework.data.domain.Page;

public interface LeaveRequestService {
    LeaveRequestStatusDto confirmLeaveRequest(Long id, LeaveRequestStatusDto leaveRequestDto);
    LeaveRequestPaginationResponse getPageLeaveRequestsWithManagerId(int pageNo, int pageSize);
}
