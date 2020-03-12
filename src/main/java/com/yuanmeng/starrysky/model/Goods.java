package com.yuanmeng.starrysky.model;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAddressType() {
        return addressType;
    }

    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }

    public String getBannerPics() {
        return bannerPics;
    }

    public void setBannerPics(String bannerPics) {
        this.bannerPics = bannerPics;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public Integer getSaleType() {
        return saleType;
    }

    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
