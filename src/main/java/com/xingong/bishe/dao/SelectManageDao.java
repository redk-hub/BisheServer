package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.SelectManageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by zhang on 2018/4/24.
 */
public interface SelectManageDao extends JpaRepository<SelectManageEntity,String> {

    @Query("select t from SelectManageEntity t where t.studentid = ?1")
    public SelectManageEntity queryById(String studentid);

    @Query("update SelectManageEntity t set t.selectIspass = ?1 where t.studentid = ?2")
    public void confirmSelect(int ispass,String studentid);
}
