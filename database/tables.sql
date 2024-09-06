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