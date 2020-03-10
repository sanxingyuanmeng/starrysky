package com.yuanmeng.starrysky.model;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Platform implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, columnDefinition = "tinyint(4) DEFAULT '0' COMMENT  '平台类型，0-小程序，1-APP'")
    private Integer type;

    @Column(nullable = true)
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @CreatedDate
    private Date createTime;

    @UpdateTimestamp
    @Column(name="_mt", nullable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private Date _mt;


}
