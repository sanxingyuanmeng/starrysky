package com.yuanmeng.starrysky.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = 32)
    private String openId;

    @Column(nullable = true, columnDefinition = "varchar(30) default NULL")
    private String unionId;

    @Column(nullable=false, length = 100)
    private String nikeName;

    @Column(nullable=true, columnDefinition ="varchar(11) default NULL" )
    private String bindPhone;

    @Column(nullable = false, length = 128)
    private String headIcon;

    @Column(nullable=false, columnDefinition = "tinyint(4) default 0")
    private Integer gender;

    @Column(length = 30)
    private String area;

    @Column(length = 30)
    private String country;

    @Column(length = 30)
    private String province;

    @Column(length = 30)
    private String city;


    @Column(nullable = false, columnDefinition = "tinyint(4) DEFAULT '0'")
    private int type;


    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private Date joinDate;


    @UpdateTimestamp
    @Column(name="last_login", nullable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private Date lastLogin;

    @UpdateTimestamp
    @Column(name="_mt", nullable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private Date _mt;







}
