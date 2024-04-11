package com.masterspring.backenddayoff.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LeaveResponse {
    private Long id;
    private LocalDateTime date;
    private Integer status;
    private String reason;
}
