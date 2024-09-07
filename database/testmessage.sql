use scMoAnnoDB;

INSERT INTO `scMoAnnoUser` (`user_name`, `psw`, `email`, `is_admin`, `phone`) VALUES
('Alice', '5f4dcc3b5aa765d61d8327deb882cf99', 'alice@example.com', false, '123-456-7890'),
('Bob', 'e99a18c428cb38d5f260853678922e03', 'bob@example.com', true, '234-567-8901'),
('Charlie', 'd8578edf8458ce06fbc5bb76a58c5ca4', 'charlie@example.com', false, '345-678-9012'),
('David', '5f4dcc3b5aa765d61d8327deb882cf99', 'david@example.com', false, '456-789-0123');

INSERT INTO `scMoAnnoTask` (`task_name`, `start_time`, `end_time`, `status`, `details`, `uploader_id`) VALUES
('Annotation Task 1', '2024-09-01 10:00:00', '2024-09-02 10:00:00', 0, 'Details about Task 1', 1),
('Annotation Task 2', '2024-09-03 09:00:00', '2024-09-04 11:00:00', 1, 'Details about Task 2', 2),
('Annotation Task 3', '2024-09-05 12:00:00', '2024-09-06 14:00:00', 0, 'Details about Task 3', 1),
('Annotation Task 4', '2024-09-07 15:00:00', '2024-09-08 16:30:00', 2, 'Details about Task 4', 3);
