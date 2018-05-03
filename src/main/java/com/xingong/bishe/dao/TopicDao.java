package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.TopicEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


/**
 * Created by zhang on 2018/4/23.
 */
public interface TopicDao extends PagingAndSortingRepository<TopicEntity,String> {

    @Query("select t from TopicEntity t where t.teacherid = ?1")
    public Page<TopicEntity> findAllByPage(String topicteacher, Pageable pageable);

    @Query("select t from TopicEntity t where t.teacherid = ?1")
    public List<TopicEntity> topicList(String userid);

    @Query("update TopicEntity t set t.topicstate = ?1 where t.topicid = ?2")
    public void updateState(int topicstate,String topicid);


    //根据id查课题
    @Query("select t from TopicEntity t where t.topicid = ?1")
    public TopicEntity queryById(String topicid);

}
