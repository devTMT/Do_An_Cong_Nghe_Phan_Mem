package com.masterspring.backenddayoff.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String fullName;

    private LocalDateTime birthDate;

    private LocalDateTime workDate;

    private String address;

    private Integer role;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "user")
    private List<LeaveRequest> leaveRequests;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private LeaveRemain leaveRemain;

    @ManyToOne
    private User manager;

    public void setLeaveRemain(LeaveRemain leaveRemain) {
        leaveRemain.setUser(this);
        this.leaveRemain = leaveRemain;
    }
}
