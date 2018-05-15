package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.DefenceManageEntity;
import com.xingong.bishe.entitys.MiddlecheckManageEntity;
import com.xingong.bishe.entitys.OpenManageEntity;
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
public interface DefenceDao extends JpaRepository<DefenceManageEntity,String> {

    @Query("select t from DefenceManageEntity  t where t.teacherid = ?1")
    public List<DefenceManageEntity> queryListByTeacherid(String teacherid);

    @Query("SELECT t.groupid FROM DefenceManageEntity t WHERE t.teacherid = ?1")
    public List<Integer> queryGroupidByTeacherid(String teacherid);

    @Query("select t from DefenceManageEntity t where t.studentid = ?1")
    public DefenceManageEntity queryByStuid(String studentid);

    @Query("select t from DefenceManageEntity t where t.teacherid = ?1")
    public List<DefenceManageEntity> queryByTeacherid(String teacherid);

    @Query("select t from DefenceManageEntity t where t.teacherid = ?1")
    public Page<DefenceManageEntity> querydefencePage(String teacherid , Pageable pageable);

    @Query("select t from DefenceManageEntity t where t.groupid = ?1")
    public List<DefenceManageEntity> queryListByGroupid(int groupid);

    //通过group by，如果有两个学生的选题是一个老师，只返回一条信息
    @Query("select t from DefenceManageEntity t where t.groupid = ?1 group by t.teachername")
    public List<DefenceManageEntity> queryGroupByGroupid(int groupid);

    @Query("select t from DefenceManageEntity t where t.groupid = ?1")
    public Page<DefenceManageEntity> queryPageByGroupid(int groupid, Pageable pageable);

    @Query("select t from DefenceManageEntity t where t.teacherid = ?1")
    public Page<DefenceManageEntity> queryMystudentPage(String teacherid , Pageable pageable);

}
