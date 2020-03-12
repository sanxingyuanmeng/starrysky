package com.yuanmeng.starrysky.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class GoodsLabels {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long goodsId;

    @Column(nullable = false, length = 128)
    private String content;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;

    @UpdateTimestamp
    @Column(name = "_mt", nullable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private Date _mt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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
