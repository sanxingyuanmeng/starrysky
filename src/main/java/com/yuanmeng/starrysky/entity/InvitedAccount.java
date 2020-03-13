package com.yuanmeng.starrysky.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户邀请表
 * </p>
 *
 * @author zsh
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("invited_account")
public class InvitedAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 被邀请用户的openid
     */
    private Integer invatedUserid;

    /**
     * 邀请用户的openid
     */
    private Integer sourceUserid;

    /**
     * 被邀请用户的进度，1-授权登录，2-开始任务
     */
    private Integer progress;

    /**
     * 邀请时间
     */
    private LocalDateTime invatedDate;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvatedUserid() {
        return invatedUserid;
    }

    public void setInvatedUserid(Integer invatedUserid) {
        this.invatedUserid = invatedUserid;
    }

    public Integer getSourceUserid() {
        return sourceUserid;
    }

    public void setSourceUserid(Integer sourceUserid) {
        this.sourceUserid = sourceUserid;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public LocalDateTime getInvatedDate() {
        return invatedDate;
    }

    public void setInvatedDate(LocalDateTime invatedDate) {
        this.invatedDate = invatedDate;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
