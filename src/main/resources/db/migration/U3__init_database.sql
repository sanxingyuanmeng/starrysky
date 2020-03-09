CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `platform_id`  int(11) NOT NULL COMMENT '商品来源',
  `reporter` varchar(32) NOT NULL COMMENT '报告人',
  `address` varchar(256) NOT NULL COMMENT '商品地址，用于展示或者跳转',
  `address_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '商品地址展示方式，0是粘贴地址，1是跳转地址',
  `pics` varchar(1000) DEFAULT NULL COMMENT '详情图片列表',
  `sale_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '商品销售方式，0是现货，1预售',
  `sale_time` datetime DEFAULT  NULL COMMENT '商品预售时间',
  `banner_pics` varchar(128) DEFAULT NULL COMMENT '商品图片',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，0-初始，1-生效，2-失效，3-删除',
  `title` varchar(256) NOT NULL COMMENT '商品标题',
  `price` varchar(128) NOT NULL COMMENT '商品价格',
  `content_title` varchar(256) NOT NULL COMMENT '详情处小标题',
  `content` varchar(2048) NOT NULL COMMENT '商品详情',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `_mt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品表';
