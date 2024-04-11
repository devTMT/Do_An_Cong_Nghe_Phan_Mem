package com.masterspring.backenddayoff.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class LeaveRequestHistoryResponse {

    @Getter
    @Setter
    public static class Request {
        private Long id;

        private LocalDateTime requestedAt;

        private LocalDate startDate;

        private LocalDate endDate;

        private String reason;

        private Integer status;
    }

    private Long userId;

    private List<Request> leaveRequests;
}
