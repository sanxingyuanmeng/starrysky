package com.yuanmeng.starrysky.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BuyHistory {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long goodsId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false, length = 128)
    private String price;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;

    @UpdateTimestamp
    @Column(name = "_mt", nullable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private Date _mt;

}