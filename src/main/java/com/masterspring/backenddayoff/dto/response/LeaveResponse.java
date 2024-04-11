package com.masterspring.backenddayoff.dto.response;

import com.masterspring.backenddayoff.entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LeaveResponse {
    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String reason;

    private Integer status;

    private LocalDateTime createdAt;

    private User user;
}
