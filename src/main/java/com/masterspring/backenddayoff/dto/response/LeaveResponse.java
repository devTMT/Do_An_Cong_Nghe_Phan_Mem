package com.masterspring.backenddayoff.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class LeaveResponse {
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;
    private String reason;
    private Integer status;
}
