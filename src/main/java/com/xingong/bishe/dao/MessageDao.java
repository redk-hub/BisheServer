package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.MessageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by zhang on 2018/5/10.
 */
public interface MessageDao extends JpaRepository<MessageEntity,String> {

    @Query("select t from MessageEntity t where t.receiverid = ?1 and t.messagestate = ?2")
    public Page<MessageEntity> queryReceiveByState(String receiverid, int state, Pageable pageable);

    @Query("select t from MessageEntity t where t.receiverid = ?1")
    public Page<MessageEntity> queryReceiveByReceiverid(String receiverid, Pageable pageable);

    @Query("select t from MessageEntity t where t.senderid = ?1 and t.messagestate = ?2")
    public Page<MessageEntity> querysendByState(String senderid, int state, Pageable pageable);

    @Query("select t from MessageEntity t where t.senderid = ?1 ")
    public Page<MessageEntity> querysendBySender(String senderid, Pageable pageable);

    @Query("select t from MessageEntity t where t.messageid = ?1")
    public MessageEntity query(String messageid);

}
