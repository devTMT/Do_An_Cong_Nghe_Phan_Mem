package com.masterspring.backenddayoff.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class LeaveRequest {
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;
    private String reason;
}
