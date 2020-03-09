CREATE TABLE `invited_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `invated_userid`  int(11) NOT NULL COMMENT '被邀请用户的openid',
  `source_userid`  int(11) NOT NULL COMMENT '邀请用户的openid',
  `progress` tinyint(4) NOT NULL DEFAULT '0' COMMENT '被邀请用户的进度，1-授权登录，2-开始任务',
  `invated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '邀请时间',
  `_mt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `invated_id` (`invated_userid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户邀请表';
