package com.masterspring.backenddayoff.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LeaveHistory {
    private Long id;
    private LocalDateTime date;
    private String status;
    private String reason;
}
