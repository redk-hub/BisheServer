package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.OpenManageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by zhang on 2018/4/26.
 */
public interface OpenManageDao extends JpaRepository<OpenManageEntity,String> {


    @Query("select t from OpenManageEntity t where t.studentid = ?1")
    public OpenManageEntity queryById(String studentid);

    @Query("update OpenManageEntity t set t.openreportIspass = ?1 where t.studentid = ?2")
    public void setReportIsPass(int isPass,String studentid);

    @Query("update OpenManageEntity t set t.wenxianIspass = ?1 where t.studentid = ?2")
    public void setWenxianIsPass(int isPass,String studentid);
}
