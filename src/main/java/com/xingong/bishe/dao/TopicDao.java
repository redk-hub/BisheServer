package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.TopicEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Created by zhang on 2018/4/23.
 */
public interface TopicDao extends PagingAndSortingRepository<TopicEntity,String> {

    @Query("select t from TopicEntity t where t.topicteacher = ?1")
    public Page<TopicEntity> findAllByPage(String topicteacher, Pageable pageable);

    @Query("update TopicEntity t set t.topicstate = ?1 where t.topicid = ?2")
    public void updateState(int topicstate,String topicid);

    //选择该题时,让已选人数加一
    @Query("update TopicEntity t set t.alreadynum = t.alreadynum +1 where t.topicid = ?1")
    public void setAlreadynum(String topicid);

    //根据id查课题
    @Query("select t from TopicEntity t where t.topicid = ?1")
    public TopicEntity queryById(String topicid);

}
