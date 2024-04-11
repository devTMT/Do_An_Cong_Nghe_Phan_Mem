package com.masterspring.backenddayoff.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "`leave_request`")
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Long id;

    @Column(name = "`start_date`")
    private LocalDateTime startDate;

    @Column(name = "`end_date`")
    private LocalDateTime endDate;

    @Column(name = "`reason`")
    private String reason;

    @Column(name = "`status`")
    private Integer status;

    @Column(name = "`created_at`")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "`user_id`")
    private User user;
}