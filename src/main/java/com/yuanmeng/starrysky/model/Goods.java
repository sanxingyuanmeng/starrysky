package com.yuanmeng.starrysky.model;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Goods implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long platformId;

    @Column(nullable = false, length=32)
    private String  reporter;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, columnDefinition = "tinyint(4) default 0")
    private Integer addressType;

    @Column(nullable = false)
    private String bannerPics;

    @Column(nullable = false)
    private String pics;

    @Column(nullable = false, columnDefinition = "tinyint(4) default 0 COMMENT '商品销售方式，0是现货，1预售'")
    private Integer saleType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date saleTime;

    @Column(nullable = false, columnDefinition = "tinyint(4) default 0 COMMENT '状态，0-初始，1-生效，2-失效，3-删除'")
    private Integer status;

    @Column(nullable = false,length=128)
    private String price;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contentTitle;

    @Column(nullable = false, length=1024)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @CreatedDate
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @CreatedDate
    private Date _mt;







}
