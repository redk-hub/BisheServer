package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.StuTopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by zhang on 2018/4/24.
 */
public interface StuTopicDao extends JpaRepository<StuTopicEntity,String> {

    @Query("select t from StuTopicEntity t where t.studentid = ?1")
    public int queryProcess(String studentid);

    @Query("update StuTopicEntity t set t.designprocess = ?1 where t.studentid = ?2")
    public void setProcess(int process,String studentid);
}
