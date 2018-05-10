package com.xingong.bishe.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by zhang on 2018/5/10.
 */
@Entity
@Table(name = "message", schema = "bishe", catalog = "")
public class MessageEntity {
    private String senderid;
    private String sendername;
    private String receiverid;
    private String receivername;
    private Integer messagestate;
    private String messagecontent;
    private Timestamp createtime;
    private String messageid;

    @Basic
    @Column(name = "senderid")
    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    @Basic
    @Column(name = "sendername")
    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername;
    }

    @Basic
    @Column(name = "receiverid")
    public String getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(String receiverid) {
        this.receiverid = receiverid;
    }

    @Basic
    @Column(name = "receivername")
    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername;
    }

    @Basic
    @Column(name = "messagestate")
    public Integer getMessagestate() {
        return messagestate;
    }

    public void setMessagestate(Integer messagestate) {
        this.messagestate = messagestate;
    }

    @Basic
    @Column(name = "messagecontent")
    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    @Basic
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (senderid != null ? !senderid.equals(that.senderid) : that.senderid != null) return false;
        if (sendername != null ? !sendername.equals(that.sendername) : that.sendername != null) return false;
        if (receiverid != null ? !receiverid.equals(that.receiverid) : that.receiverid != null) return false;
        if (receivername != null ? !receivername.equals(that.receivername) : that.receivername != null) return false;
        if (messagestate != null ? !messagestate.equals(that.messagestate) : that.messagestate != null) return false;
        if (messagecontent != null ? !messagecontent.equals(that.messagecontent) : that.messagecontent != null)
            return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = senderid != null ? senderid.hashCode() : 0;
        result = 31 * result + (sendername != null ? sendername.hashCode() : 0);
        result = 31 * result + (receiverid != null ? receiverid.hashCode() : 0);
        result = 31 * result + (receivername != null ? receivername.hashCode() : 0);
        result = 31 * result + (messagestate != null ? messagestate.hashCode() : 0);
        result = 31 * result + (messagecontent != null ? messagecontent.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }

    @Id
    @Column(name = "messageid")
    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }
}
