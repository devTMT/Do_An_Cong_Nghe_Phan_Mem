package com.masterspring.backenddayoff.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "leave_remains")
public class LeaveRemain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer remainDays;

    private Integer year;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
