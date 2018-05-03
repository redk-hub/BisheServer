package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.CollegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by zhang on 2018/5/2.
 */
public interface CollegeDao extends JpaRepository<CollegeEntity,Integer> {

    @Query("select t from CollegeEntity t order by t.collegeid")
    public List<CollegeEntity> queryAllCollege();
}
