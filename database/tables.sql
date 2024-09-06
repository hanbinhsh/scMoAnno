use scMoAnnoDB;

drop table if exists `scMoAnnoUser`;
create table `scMoAnnoUser`(
  `user_id` int AUTO_INCREMENT PRIMARY KEY  	NOT NULL	COMMENT '用户ID',
  `user_name` varchar(20) UNIQUE				NOT NULL	COMMENT '用户名',
  `psw` varchar(64)  							NOT NULL	COMMENT '用户密码',
  `email` varchar(32) UNIQUE 					NOT NULL	COMMENT '电子邮件',
  `is_admin` boolean DEFAULT false	 			NOT NULL	COMMENT '是否是管理员',
  `phone` varchar(32) UNIQUE				 	NOT NULL	COMMENT '电话号码'
);

drop table if exists `scMoAnnoTask`;
create table `scMoAnnoTask`(
  `task_id` int AUTO_INCREMENT PRIMARY KEY  	NOT NULL	COMMENT '任务ID',
  `task_name` varchar(20) UNIQUE				NOT NULL	COMMENT '任务名',
  `start_time` datetime				 			NOT NULL	COMMENT '开始时间',
  `end_time` datetime				 			NOT NULL	COMMENT '结束时间',
  `status` tinyint DEFAULT 0					NOT NULL	COMMENT '标志位',
  `details` text								NOT NULL	COMMENT '详情',
  `uploader_id` int 							NOT NULL	COMMENT '上传者ID',
  FOREIGN KEY (`uploader_id`) REFERENCES scMoAnnoUser(`user_id`)
);