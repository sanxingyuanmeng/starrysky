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

    @Column(nullable = false, unique = true, columnDefinition = "微信open_id")
    private String openId;

    @Column(nullable = true, columnDefinition = "统一id")
    private String unionId;

    @Column(nullable=false, columnDefinition = "微信昵称")
    private String nikeName;

    @Column(nullable=true, columnDefinition = "绑定手机号")
    private String bindPhone;

    @Column(nullable = false, columnDefinition = "头像地址", length = 128)
    private String headIcon;

    @Column(nullable=false, precision = 0, columnDefinition = "性别， 0未知， 1男， 2女")
    private int gender;

    @Column(length = 30)
    private String area;

    @Column(length = 30)
    private String country;

    @Column(length = 30, columnDefinition = "省份")
    private String province;

    @Column(length = 30, columnDefinition = "城市")
    private String city;

    @Column(nullable = false, length = 8, columnDefinition = "类型", precision = 0)
    private int type;

    //@Column()






}
