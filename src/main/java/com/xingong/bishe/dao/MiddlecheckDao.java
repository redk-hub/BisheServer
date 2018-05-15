package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.DefenceManageEntity;
import com.xingong.bishe.entitys.MiddlecheckManageEntity;
import com.xingong.bishe.entitys.SelectManageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query("SELECT t.groupid FROM MiddlecheckManageEntity t WHERE t.teacherid = ?1")
    public List<Integer> queryGroupidByTeacherid(String teacherid);

    @Query("select t from MiddlecheckManageEntity t where t.groupid = ?1")
    public List<MiddlecheckManageEntity> queryListByGroupid(int groupid);

    @Query("select t.groupid from MiddlecheckManageEntity t where t.studentid = ?1")
    public int queryGroupidByStuid(String studentid);

    @Query("select t from MiddlecheckManageEntity t where t.studentid = ?1")
    public MiddlecheckManageEntity queryByStudentid(String  studentid);

    @Query("select t.teachername from MiddlecheckManageEntity t where t.groupid = ?1")
    public List<String> queryTeacherByGroupid(int groupid);

    @Query("select t from MiddlecheckManageEntity t where t.teacherid = ?1")
    public Page<MiddlecheckManageEntity> queryMystudentPage(String teacherid , Pageable pageable);

    @Query("select t from MiddlecheckManageEntity t where t.groupid = ?1 group by t.teachername")
    public List<MiddlecheckManageEntity> queryGroupByGroupid(int groupid);
}
