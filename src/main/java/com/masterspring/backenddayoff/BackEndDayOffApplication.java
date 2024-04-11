package com.masterspring.backenddayoff;

import com.masterspring.backenddayoff.entity.Department;
import com.masterspring.backenddayoff.entity.LeaveRemain;
import com.masterspring.backenddayoff.entity.LeaveRequest;
import com.masterspring.backenddayoff.entity.User;
import com.masterspring.backenddayoff.repository.DepartmentRepository;
import com.masterspring.backenddayoff.repository.LeaveRequestRepository;
import com.masterspring.backenddayoff.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class BackEndDayOffApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndDayOffApplication.class, args);
    }

//    @Bean
//    public ApplicationRunner runner(UserRepository userRepository, DepartmentRepository departmentRepository, LeaveRequestRepository leaveRequestRepository) {
//        String[] names = {"Craig Berry", "Johnny Gardner", "Maxwell Salazar", "Alec Holden", "Floyd Hayward"};
//        String[] address = {"21246 Reichert Corners Apt. 232", "7045 Stanton Meadow", "21788 Leffler Vista Suite 094", "7779 Enola Hills", "268 Amalia Lock Apt. 253"};
//        return args -> {
//            var department = new Department();
//            department.setName("IT");
//            departmentRepository.save(department);
//
//            for (int i = 0; i < 5; i++) {
//                var email = "";
//                if (i == 0) email = "user_manager@gmail.com";
//                else if (i == 1) email = "user_admin@gmail.com";
//                else email = "user%s@gmail.com".formatted(i);
//                User.Role role;
//
//                if (i == 0) role = User.Role.MANAGER;
//                else if (i == 1) role = User.Role.ADMIN;
//                else role = User.Role.USER;
//
//                var user = User.builder()
//                        .email(email)
//                        .password("00000000")
//                        .fullName(names[i])
//                        .address(address[i])
//                        .birthDate(LocalDateTime.now().minusYears(25))
//                        .workDate(LocalDateTime.now())
//                        .phone("123456789")
//                        .role(role)
//                        .department(department)
//                        .build();
//
//                var leaveRemain = new LeaveRemain();
//                leaveRemain.setRemainDays(10);
//                leaveRemain.setYear(2024);
//
//                user.setLeaveRemain(leaveRemain);
//
//                if (i == 0) user.setManager(null);
//                else {
//                    var manager = userRepository.findByEmailAndPassword("user_manager@gmail.com", "00000000");
//                    user.setManager(manager);
//                }
//
//                userRepository.saveAndFlush(user);
//
//                for (int j = 0; j < 2; j++) {
//                    var leaveRequest = new LeaveRequest();
//                    leaveRequest.setUser(user);
//                    leaveRequest.setStartDate(LocalDateTime.of(2024, 4, 7, 0, 0));
//                    leaveRequest.setEndDate(LocalDateTime.of(2024, 4, 8, 23, 59));
//                    leaveRequest.setReason("Sick");
//                    leaveRequest.setCreatedAt(LocalDateTime.now());
//                    leaveRequest.setStatus(0);
//                    leaveRequestRepository.saveAndFlush(leaveRequest);
//                }
//            }
//        };
//    }
}
