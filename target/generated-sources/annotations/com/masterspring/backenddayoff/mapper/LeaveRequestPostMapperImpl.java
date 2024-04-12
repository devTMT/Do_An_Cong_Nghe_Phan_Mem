package com.masterspring.backenddayoff.mapper;

import com.masterspring.backenddayoff.dto.request.LeaveRequestPost;
import com.masterspring.backenddayoff.dto.response.LeaveRequestPostResponse;
import com.masterspring.backenddayoff.entity.LeaveRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-12T14:47:41+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class LeaveRequestPostMapperImpl implements LeaveRequestPostMapper {

    @Override
    public LeaveRequest leaveRequestPostToLeaveRequest(LeaveRequestPost leaveRequestPost) {
        if ( leaveRequestPost == null ) {
            return null;
        }

        LeaveRequest.LeaveRequestBuilder leaveRequest = LeaveRequest.builder();

        leaveRequest.startDate( leaveRequestPost.getStartDate() );
        leaveRequest.endDate( leaveRequestPost.getEndDate() );
        leaveRequest.reason( leaveRequestPost.getReason() );
        leaveRequest.createdAt( leaveRequestPost.getCreatedAt() );

        return leaveRequest.build();
    }

    @Override
    public LeaveRequestPostResponse leaveRequestToLeaveRequestPostResponse(LeaveRequest leaveRequest) {
        if ( leaveRequest == null ) {
            return null;
        }

        LeaveRequestPostResponse leaveRequestPostResponse = new LeaveRequestPostResponse();

        leaveRequestPostResponse.setId( leaveRequest.getId() );
        leaveRequestPostResponse.setStartDate( leaveRequest.getStartDate() );
        leaveRequestPostResponse.setEndDate( leaveRequest.getEndDate() );
        leaveRequestPostResponse.setCreatedAt( leaveRequest.getCreatedAt() );
        leaveRequestPostResponse.setReason( leaveRequest.getReason() );
        leaveRequestPostResponse.setStatus( leaveRequest.getStatus() );

        leaveRequestPostResponse.setCreatedBy( leaveRequest.getUser().getId() );

        return leaveRequestPostResponse;
    }
}
