package com.yuanmeng.starrysky.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String openId;

    @Column(nullable = true)
    private String unionId;

    @Column(nullable=false)
    private String nikeName;

    @Column(nullable=true)
    private String bindPhone;

    @Column(nullable = false, length = 128)
    private String headIcon;

    @Column(nullable=false, precision = 0)
    private int gender;

    @Column(length = 30)
    private String area;

    @Column(length = 30)
    private String country;

    @Column(length = 30)
    private String province;

    @Column(length = 30)
    private String city;

    @Column(nullable = false, length = 8, precision = 0)
    private int type;

    //@Column()






}
