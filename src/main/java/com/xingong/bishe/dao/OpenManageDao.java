package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.OpenManageEntity;
import com.xingong.bishe.entitys.SelectManageEntity;
import org.apache.commons.fileupload.util.LimitedInputStream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhang on 2018/4/26.
 */
public interface OpenManageDao extends JpaRepository<OpenManageEntity,String> {


    @Query("select t from OpenManageEntity t where t.studentid = ?1")
    public List<OpenManageEntity> queryListById(String studentid);

    @Query("select t from OpenManageEntity t where t.studentid = ?1")
    public OpenManageEntity queryById(String studentid);

    @Query("select t from OpenManageEntity t where t.teacherid = ?1")
    public Page<OpenManageEntity> queryOpenPage(String teacherid , Pageable pageable);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update open_manage t set t.openreport_ispass = ?1 and t.openreport_score = ?2 and t.openreport_suggest = ?3 where t.studentid = ?4",nativeQuery = true)
    public void setReportIsPass(int isPass,int score,String suggest,String studentid);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update open_manage t set t.wenxian_ispass = ?1 and t.wenxian_score = ?2 and t.wenxian_suggest = ?3 where t.studentid = ?4",nativeQuery = true)
    public void setWenxianIsPass(int isPass,int score,String suggest,String studentid);
}
