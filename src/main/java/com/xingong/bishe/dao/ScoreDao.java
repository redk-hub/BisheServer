package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.DefenceManageEntity;
import com.xingong.bishe.entitys.ScoreManageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by zhang on 2018/5/10.
 */
public interface ScoreDao extends JpaRepository<ScoreManageEntity,String> {

    @Query("select t from ScoreManageEntity t where t.studentid = ?1")
    public ScoreManageEntity queryByStuid(String studentid);

    @Query("select t from ScoreManageEntity t where t.teacherid = ?1")
    public Page<ScoreManageEntity> queryScorePage(String teacherid , Pageable pageable);
}
