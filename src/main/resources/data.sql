INSERT INTO `departments`(`id`, `name`)
VALUES (1, 'IT');

INSERT INTO `users`(`id`, `email`, `password`, `full_name`, `birthdate`, `work_date`, `address`, `phone`, `role`, `department_id`, `manager_id`)
VALUES (1, 'manager@gmail.com', '00000000', 'Craig Berry', '1990-09-12', '2023-01-01', '21246 Richard Corners Apt. 232', '0123456789', 0, '1', null),
       (2, 'admin@gmail.com', '00000000', 'Johnny Gardner', '1995-04-24', '2023-01-29', '7045 Stanton Meadow', '0123456789', 1, '1', 1),
       (3, 'user1@gmail.com', '00000000', 'Maxwell Salazar', '1997-01-11', '2023-06-10', '21788 Leffler Vista Suite 094', '0123456789', 2, '1', 1),
       (4, 'user2@gmail.com', '00000000', 'Alec Holden', '1998-09-05', '2024-01-13', '7779 Ella Hills', '0123456789', 2, '1', 1),
       (5, 'user3@gmail.com', '00000000', 'Floyd Hayward', '1999-05-17', '2024-02-11', '268 Amalia Lock Apt. 253', '0123456789', 2, '1', 1);

INSERT INTO `leave_remains`(`id`, `remain_days`, `year`, `user_id`)
VALUES (1, 24, 2024, 1),
       (2, 24, 2024, 2),
       (3, 21, 2024, 3),
       (4, 8, 2024, 4),
       (5, 7, 2024, 5);

INSERT INTO `leave_requests`(`id`, `created_at`, `start_date`, `end_date`, `reason`, `status`, `user_id`)

VALUES (1, '2023-08-10T09:12:00', '2023-08-15', '2023-08-18', 'Sick', 0, 3),
       (2, '2024-03-02T08:20:00', '2024-03-03', '2024-03-10', 'Wife gives birth', 0, 3),
       (3, '2024-04-04T12:38:00', '2024-05-10', '2024-05-12', 'Visit family', 2, 3),

       (4, '2024-02-11T11:24:00', '2024-02-20', '2024-02-21', 'Go wedding', 0, 4),
       (5, '2024-02-03T07:56:00', '2024-02-09', '2024-02-12', 'Visit family', 0, 4),
       (6, '2024-03-05T10:55:00', '2024-03-07', '2024-03-08', 'Dating', 0, 4),
       (7, '2024-05-01T12:11:00', '2024-05-10', '2024-05-16', 'Wife gives birth', 0, 4),

       (8, '2024-06-21T17:03:00', '2024-06-25', '2024-06-26', 'Dating', 2, 5),
       (9, '2024-03-09T15:00:00', '2024-03-10', '2024-03-11', 'Go wedding', 0, 5),
       (10, '2024-03-10T23:27:00', '2024-03-12', '2024-03-14', 'Personal work', 0, 5),
       (11, '2024-04-21T18:59:00', '2024-04-23', '2024-04-30', 'Wife gives birth', 1, 5),
       (12, '2024-04-07T20:01:00', '2024-04-11', '2024-04-12', 'Go wedding', 1, 5);