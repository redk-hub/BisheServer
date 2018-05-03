package com.xingong.bishe.services;

import com.xingong.bishe.dao.TopicDao;
import com.xingong.bishe.entitys.TopicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Page<TopicEntity> findAllByPage(String topicteacher, Pageable pageable){
//        List<TopicEntity> topicList = topicDao.topicList(topicteacher);
        if (topicteacher.equals("")){
            return topicDao.findAll(pageable);
        }else if (topicDao.topicList(topicteacher).size() == 0){
            return null;
        }
        return topicDao.findAllByPage(topicteacher,pageable);
    }

    public boolean selectTopic(String topicid){
        TopicEntity topicEntity = topicDao.queryById(topicid);
        if (topicEntity.getAlreadynum()<topicEntity.getSupplynum()){
            topicEntity.setAlreadynum(topicEntity.getAlreadynum()+1);
            topicDao.save(topicEntity);
            return true;
        }else {
            return false;
        }
    }

}
