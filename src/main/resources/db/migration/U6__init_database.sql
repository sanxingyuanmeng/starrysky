CREATE TABLE `ugc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL COMMENT '评价商品id',
  `source_userid`  int(11) NOT NULL COMMENT '评价用户id',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户评价，0-未评价,1-稀缺,2-不稀缺',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `_mt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`),

) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户评论表';
/*!40101 SET character_set_client = @saved_cs_client */;