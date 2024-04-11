package com.masterspring.backenddayoff.mapper;

import com.masterspring.backenddayoff.dto.response.LeaveRequestHistoryResponse;
import com.masterspring.backenddayoff.entity.LeaveRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T23:47:47+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class LeaveRequestHistoryMapperImpl implements LeaveRequestHistoryMapper {

    @Override
    public LeaveRequestHistoryResponse.Request fromleaveRequest(LeaveRequest leaveRequest) {
        if ( leaveRequest == null ) {
            return null;
        }

        LeaveRequestHistoryResponse.Request request = new LeaveRequestHistoryResponse.Request();

        request.setRequestedAt( leaveRequest.getCreatedAt() );
        request.setId( leaveRequest.getId() );
        request.setStartDate( leaveRequest.getStartDate() );
        request.setEndDate( leaveRequest.getEndDate() );
        request.setReason( leaveRequest.getReason() );
        request.setStatus( leaveRequest.getStatus() );

        return request;
    }
}
