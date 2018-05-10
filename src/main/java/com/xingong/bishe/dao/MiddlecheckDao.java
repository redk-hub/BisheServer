package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.MiddlecheckManageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhang on 2018/5/10.
 */
public interface MiddlecheckDao extends JpaRepository<MiddlecheckManageEntity,String> {

    @Query("select t from MiddlecheckManageEntity  t where t.teacherid = ?1")
    public List<MiddlecheckManageEntity> queryListByTeacherid(String teacherid);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "SELECT t.groupid FROM middlecheck_manage t WHERE t.teacherid = ?1 limit 1",nativeQuery = true)
    public int queryGroupidByTeacherid(String teacherid);

    @Query("select t from MiddlecheckManageEntity t where t.groupid = ?1")
    public List<MiddlecheckManageEntity> queryListByGroupid(int groupid);

    @Query("select t.groupid from MiddlecheckManageEntity t where t.studentid = ?1")
    public int queryGroupidByStuid(String studentid);

    @Query("select t from MiddlecheckManageEntity t where t.studentid = ?1")
    public MiddlecheckManageEntity queryByStudentid(String  studentid);
}
