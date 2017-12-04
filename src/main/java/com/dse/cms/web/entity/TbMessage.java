package com.dse.cms.web.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * ${DESCRIPTION}
 *
 * @author wangzy
 * @date 2017-11-29
 */
@Entity
@Table(name = "tb_message")
public class TbMessage implements Serializable {
    private String id;
    private String msgTitle;
    private String msgContent;
    private String createUser;
    private Timestamp createTime;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer deleted;
    private String updateUser;
    private Timestamp updateTime;

    @Id
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "msg_title", nullable = true, length = 50)
    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    @Basic
    @Column(name = "msg_content", nullable = true, length = 500)
    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    @Basic
    @Column(name = "create_user", nullable = true, length = 20)
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "start_time", nullable = true)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = true)
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "deleted", nullable = true)
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "update_user", nullable = true, length = 20)
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbMessage tbMessage = (TbMessage) o;

        if (id != null ? !id.equals(tbMessage.id) : tbMessage.id != null) return false;
        if (msgTitle != null ? !msgTitle.equals(tbMessage.msgTitle) : tbMessage.msgTitle != null) return false;
        if (msgContent != null ? !msgContent.equals(tbMessage.msgContent) : tbMessage.msgContent != null) return false;
        if (createUser != null ? !createUser.equals(tbMessage.createUser) : tbMessage.createUser != null) return false;
        if (createTime != null ? !createTime.equals(tbMessage.createTime) : tbMessage.createTime != null) return false;
        if (startTime != null ? !startTime.equals(tbMessage.startTime) : tbMessage.startTime != null) return false;
        if (endTime != null ? !endTime.equals(tbMessage.endTime) : tbMessage.endTime != null) return false;
        if (deleted != null ? !deleted.equals(tbMessage.deleted) : tbMessage.deleted != null) return false;
        if (updateUser != null ? !updateUser.equals(tbMessage.updateUser) : tbMessage.updateUser != null) return false;
        return updateTime != null ? updateTime.equals(tbMessage.updateTime) : tbMessage.updateTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (msgTitle != null ? msgTitle.hashCode() : 0);
        result = 31 * result + (msgContent != null ? msgContent.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
