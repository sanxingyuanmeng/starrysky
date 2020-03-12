package com.yuanmeng.starrysky.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Ugc {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long goodsId;

    @Column(nullable = false)
    private Long sourceUserid;

    @Column(nullable = false, columnDefinition = "tinyint(4) default 0 COMMENT '用户评价，0-未评价,1-稀缺,2-不稀缺'")
    private Integer type;

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

    public Long getSourceUserid() {
        return sourceUserid;
    }

    public void setSourceUserid(Long sourceUserid) {
        this.sourceUserid = sourceUserid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
