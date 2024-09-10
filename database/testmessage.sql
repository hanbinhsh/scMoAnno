use scMoAnnoDB;

INSERT INTO `scMoAnnoUser` (`user_name`, `psw`, `email`, `is_admin`, `phone`) VALUES
('Alice', '3', 'alice@example.com', true, '123-456-7890'),
('Bob', '3', 'bob@example.com', true, '234-567-8901'),
('Charlie', '3', 'charlie@example.com', false, '345-678-9012'),
('David', '3', 'david@example.com', false, '456-789-0123');

INSERT INTO `scMoAnnoTask` (`task_name`, `start_time`, `end_time`, `status`, `details`, `uploader_id`) VALUES
('Annotation Task 1', '2024-09-01 10:00:00', '2024-09-02 10:00:00', 0, 'Details about Task 1', 9),
('Annotation Task 2', '2024-09-03 09:00:00', '2024-09-04 11:00:00', 1, 'Details about Task 2', 9),
('Annotation Task 3', '2024-09-05 12:00:00', '2024-09-06 14:00:00', 0, 'Details about Task 3', 9),
('Annotation Task 4', '2024-09-07 15:00:00', '2024-09-08 16:30:00', 2, 'Details about Task 4', 9);

