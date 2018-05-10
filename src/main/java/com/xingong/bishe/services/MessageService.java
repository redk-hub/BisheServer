package com.xingong.bishe.services;

import com.xingong.bishe.dao.MessageDao;
import com.xingong.bishe.entitys.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhang on 2018/5/10.
 */
@Service
@Transactional
public class MessageService {

    @Autowired
    MessageDao messageDao;

    //根据状态分页查询
    public Page<MessageEntity> queryReceiveByState(String receiverid, int state, Pageable pageable){
        return messageDao.queryReceiveByState(receiverid, state, pageable);
    }

    //根据状态分页查询
    public Page<MessageEntity> querySendByState(String senderid, int state, Pageable pageable){
        return messageDao.querysendByState(senderid, state, pageable);
    }

    public void setState(String messageid,int state){
        MessageEntity messageEntity = messageDao.query(messageid);
        messageEntity.setMessagestate(state);
        messageDao.save(messageEntity);
    }
}
