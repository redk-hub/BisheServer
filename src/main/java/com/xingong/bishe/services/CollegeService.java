package com.xingong.bishe.services;

import com.xingong.bishe.dao.CollegeDao;
import com.xingong.bishe.dao.MajorDao;
import com.xingong.bishe.entitys.CollegeEntity;
import com.xingong.bishe.entitys.MajorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhang on 2018/5/2.
 */
@Service
@Transactional
public class CollegeService {

    @Autowired
    CollegeDao collegeDao;

    @Autowired
    MajorDao majorDao;

    /**
     * 获取学院的list列表
     * @return
     */
    public List<CollegeEntity> queryAllCollege(){
        return collegeDao.queryAllCollege();
    }

    /**
     * 根据学院id查询专业列表
     * @param collegeid
     * @return
     */
    public List<MajorEntity> queryAllMajor(int collegeid){
        return majorDao.queryAllMajor(collegeid);
    }
}
