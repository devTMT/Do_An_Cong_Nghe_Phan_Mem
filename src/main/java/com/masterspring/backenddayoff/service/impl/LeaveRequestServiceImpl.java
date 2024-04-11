package com.masterspring.backenddayoff.service.impl;

import com.masterspring.backenddayoff.dto.LeaveRequestDto;
import com.masterspring.backenddayoff.entity.LeaveRequest;
import com.masterspring.backenddayoff.exception.AppException;
import com.masterspring.backenddayoff.repository.LeaveRequestRepository;
import com.masterspring.backenddayoff.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    public LeaveRequestServiceImpl(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }


    @Override
    public LeaveRequestDto confirmLeaveRequest(Long id, LeaveRequestDto leaveRequestDto) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow(()
                -> new AppException(500, "could not found"));
        updateStatus(leaveRequest, leaveRequestDto);
        leaveRequestRepository.save(leaveRequest);
        LeaveRequestDto response = new LeaveRequestDto();
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

    public void updateStatus(LeaveRequest leaveRequest, LeaveRequestDto leaveRequestDto){
        if(leaveRequestDto.getStatus().equals("reject")){
            leaveRequest.setStatus(0);
        }else if(leaveRequestDto.getStatus().equals("accept")){
            leaveRequest.setStatus(1);
        }else{
            leaveRequest.setStatus(2);
        }
    }
}
