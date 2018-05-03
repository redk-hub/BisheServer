package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.MajorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by zhang on 2018/5/3.
 */
public interface MajorDao extends JpaRepository<MajorEntity,Integer> {
    @Query("select t from MajorEntity t where t.collegeid = ?1 order by t.majorid")
    public List<MajorEntity> queryAllMajor(int collegeid);
}
