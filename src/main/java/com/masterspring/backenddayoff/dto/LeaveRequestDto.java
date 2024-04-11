package com.masterspring.backenddayoff.dto;

import lombok.Data;

@Data
public class LeaveRequestDto {
    private long id;
    private String status;
    private long manager_id;
}
