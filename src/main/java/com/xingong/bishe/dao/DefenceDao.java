package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.DefenceManageEntity;
import com.xingong.bishe.entitys.OpenManageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhang on 2018/5/10.
 */
public interface DefenceDao extends JpaRepository<DefenceManageEntity,String> {

    @Query("select t from DefenceManageEntity t where t.studentid = ?1")
    public DefenceManageEntity queryByStuid(String studentid);

    @Query("select t from DefenceManageEntity t where t.teacherid = ?1")
    public Page<DefenceManageEntity> querydefencePage(String teacherid , Pageable pageable);

}
