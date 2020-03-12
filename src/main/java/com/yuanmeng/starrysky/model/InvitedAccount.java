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
public class InvitedAccount implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long invatedUserid;

    @Column(nullable = false)
    private Long sourceUserid;

    @Column(nullable=false, columnDefinition = "tinyint(4) default 0")
    private Integer progress;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private Date invatedDate;

    @UpdateTimestamp
    @Column(name="_mt", nullable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private Date _mt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvatedUserid() {
        return invatedUserid;
    }

    public void setInvatedUserid(Long invatedUserid) {
        this.invatedUserid = invatedUserid;
    }

    public Long getSourceUserid() {
        return sourceUserid;
    }

    public void setSourceUserid(Long sourceUserid) {
        this.sourceUserid = sourceUserid;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Date getInvatedDate() {
        return invatedDate;
    }

    public void setInvatedDate(Date invatedDate) {
        this.invatedDate = invatedDate;
    }
}
