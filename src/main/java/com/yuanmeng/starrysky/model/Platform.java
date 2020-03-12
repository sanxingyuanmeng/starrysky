package com.yuanmeng.starrysky.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;

    @UpdateTimestamp
    @Column(name="_mt", nullable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private Date _mt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
