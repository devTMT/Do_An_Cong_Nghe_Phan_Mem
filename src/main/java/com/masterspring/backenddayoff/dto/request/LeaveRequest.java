package com.masterspring.backenddayoff.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class LeaveRequest {
    private Long userId;
    private List<LocalDateTime> dates;
    private String reason;
}
