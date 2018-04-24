package com.xingong.bishe.services;

import com.xingong.bishe.dao.TopicDao;
import com.xingong.bishe.entitys.TopicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhang on 2018/4/23.
 */

@Service
@Transactional
public class TopicService {

    @Autowired
    TopicDao topicDao;

    /**
     * 保存课题
     * @param topicEntity
     */
    public void saveTopic(TopicEntity topicEntity){
        topicDao.save(topicEntity);
    }

    public void updateState(int topicstate,String topicid){
        topicDao.updateState(topicstate,topicid);
    }

    /**
     * 分页查询课题
     * @param pageable
     * @return
     */
    public Page<TopicEntity> findAllByPage(String topicteacher,Pageable pageable){
        if (topicteacher.equals("")){
            return topicDao.findAll(pageable);
        }
        return topicDao.findAllByPage(topicteacher,pageable);
    }

    public boolean selectTopic(String topicid){
        TopicEntity topicEntity = topicDao.queryById(topicid);
        if (topicEntity.getAlreadynum()<topicEntity.getSupplynum()){
            topicDao.setAlreadynum(topicid);
            return true;
        }else {
            return false;
        }
    }

}
