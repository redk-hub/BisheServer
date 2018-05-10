package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.SelectManageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhang on 2018/4/24.
 */
public interface SelectManageDao extends JpaRepository<SelectManageEntity,String> {

    @Query("select t from SelectManageEntity t where t.teacherid = ?1")
    public Page<SelectManageEntity> querySelectPage(String teacherid , Pageable pageable);

    @Query("select t from SelectManageEntity t where t.teacherid = ?1 and t.selectIspass = 1")
    public Page<SelectManageEntity> querySuccessPage(String teacherid , Pageable pageable);

    @Query("select t from SelectManageEntity t where t.studentid = ?1")
    public SelectManageEntity queryById(String studentid);

    @Query("select t from SelectManageEntity t where t.topicname = ?1")
    public List<SelectManageEntity> queryByTopicname(String topicname);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update select_manage t set t.select_ispass = ?1 where t.studentid = ?2",nativeQuery = true)
    public void confirmSelect(int ispass,String studentid);


    @Query("select t from SelectManageEntity t where t.topicname = ?1")
    public List<SelectManageEntity> queryAllByTopicname(String topicname);

    @Query("select t.topicname from SelectManageEntity t where t.studentid = ?1")
    public String getTopicname(String studentid);

}
