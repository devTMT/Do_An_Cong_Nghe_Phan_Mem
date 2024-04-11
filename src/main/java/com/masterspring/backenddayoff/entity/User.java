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
@Table(name = "`users`")
public class User {

    public enum Role {
        MANAGER, ADMIN, USER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Long id;

    @Column(name = "`email`", unique = true)
    private String email;

    @Column(name = "`password`")
    private String password;

    @Column(name = "`full_name`")
    private String fullName;

    @Column(name = "`birth_date`")
    private LocalDateTime birthDate;

    @Column(name = "`work_date`")
    private LocalDateTime workDate;

    @Column(name = "`address`")
    private String address;

    @Column(name = "`phone`")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "`role`")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "`department_id`")
    private Department department;

    @OneToMany(mappedBy = "user")
    private List<LeaveRequest> leaveRequests;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private LeaveRemain leaveRemain;

    @ManyToOne
    @JoinColumn(name = "`manager_id`")
    private User manager;

    public void setLeaveRemain(LeaveRemain leaveRemain) {
        leaveRemain.setUser(this);
        this.leaveRemain = leaveRemain;
    }
}
