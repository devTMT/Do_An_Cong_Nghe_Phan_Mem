package com.masterspring.backenddayoff.mapper;

import com.masterspring.backenddayoff.dto.response.LeaveRequestHistoryResponse;
import com.masterspring.backenddayoff.entity.LeaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LeaveRequestHistoryMapper {

    @Mapping(target = "requestedAt", source = "createdAt")
    LeaveRequestHistoryResponse.Request fromleaveRequest(LeaveRequest leaveRequest);
}
