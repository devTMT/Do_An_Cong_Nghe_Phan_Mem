package com.masterspring.backenddayoff.service.impl;

import com.masterspring.backenddayoff.dto.LeaveRequestStatusDto;
import com.masterspring.backenddayoff.dto.response.LeaveRequestPaginationResponse;
import com.masterspring.backenddayoff.dto.response.LeaveRequestResponse;
import com.masterspring.backenddayoff.entity.LeaveRequest;
import com.masterspring.backenddayoff.exception.AppException;
import com.masterspring.backenddayoff.repository.LeaveRequestRepository;
import com.masterspring.backenddayoff.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    public LeaveRequestServiceImpl(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }


    @Override
    public LeaveRequestStatusDto confirmLeaveRequest(Long id, LeaveRequestStatusDto leaveRequestDto) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow(()
                -> new AppException(500, "could not found"));
        updateStatus(leaveRequest, leaveRequestDto);
        leaveRequestRepository.save(leaveRequest);
        LeaveRequestStatusDto response = new LeaveRequestStatusDto();
        response.setId(leaveRequest.getId());
        if(leaveRequest.getStatus() == 1){
            response.setStatus("accept");
        }else if(leaveRequest.getStatus() == 0){
            response.setStatus("reject");
        }else{
            response.setStatus("waiting");
        }
        response.setManager_id(leaveRequest.getUser().getId());
        return response;
    }

    @Override
    public LeaveRequestPaginationResponse getPageLeaveRequestsWithManagerId(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<LeaveRequest> leaveRequestPage = leaveRequestRepository.findAll(pageable);
        List<LeaveRequestResponse> content = leaveRequestPage.getContent().stream().map(leaveRequest ->
            mapToResponse(leaveRequest)).collect(Collectors.toList());
        LeaveRequestPaginationResponse response = new LeaveRequestPaginationResponse();
        response.setContent(content);
        response.setPageNo(leaveRequestPage.getNumber());
        response.setPageSize(leaveRequestPage.getSize());
        response.setTotalElements(leaveRequestPage.getTotalElements());
        response.setTotalPages(leaveRequestPage.getTotalPages());
        return response;
    }

    public void updateStatus(LeaveRequest leaveRequest, LeaveRequestStatusDto leaveRequestDto){
        if(leaveRequestDto.getStatus().equals("reject")){
            leaveRequest.setStatus(0);
        }else if(leaveRequestDto.getStatus().equals("accept")){
            leaveRequest.setStatus(1);
        }else{
            leaveRequest.setStatus(2);
        }
    }

    public LeaveRequestResponse mapToResponse(LeaveRequest leaveRequest){
        LeaveRequestResponse leaveRequestResponse = new LeaveRequestResponse();
        leaveRequestResponse.setId(leaveRequest.getId());
        leaveRequestResponse.setDate(leaveRequest.getDate());
        leaveRequestResponse.setReason(leaveRequest.getReason());
        leaveRequestResponse.setStatus(leaveRequest.getStatus());
        leaveRequestResponse.setCreatedAt(leaveRequest.getCreatedAt());
        leaveRequestResponse.setUsername(leaveRequest.getUser().getFullName());
        if(leaveRequest.getUser().getManager() == null){
            leaveRequestResponse.setManager("I am manager");
        }else{
            leaveRequestResponse.setManager(leaveRequest.getUser().getManager().getFullName());
        }
        return leaveRequestResponse;
    }
    public LeaveRequest mapToEntity(LeaveRequestResponse leaveRequestResponse){
        LeaveRequest leaveRequest = LeaveRequest.builder()
                .id(leaveRequestResponse.getId())
                .date(leaveRequestResponse.getDate())
                .reason(leaveRequestResponse.getReason())
                .status(leaveRequestResponse.getStatus())
                .createdAt(leaveRequestResponse.getCreatedAt())
                .build();
        return leaveRequest;
    }
}
