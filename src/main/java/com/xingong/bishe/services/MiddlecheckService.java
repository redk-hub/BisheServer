package com.xingong.bishe.services;

import com.xingong.bishe.dao.MiddlecheckDao;
import com.xingong.bishe.entitys.MiddlecheckManageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhang on 2018/5/10.
 */
@Service
@Transactional
public class MiddlecheckService {

    @Autowired
    MiddlecheckDao middlecheckDao;


    public List<MiddlecheckManageEntity> queryMiddleList(String teacherid){
        return middlecheckDao.queryListByTeacherid(teacherid);
    }

    //第一组检查第二组，第五组检查第一组
    public List<MiddlecheckManageEntity> queryCheckGroup(String teacherid){

        int groupid = middlecheckDao.queryGroupidByTeacherid(teacherid);
        List<MiddlecheckManageEntity> middleList;
        if (groupid == 5){
            middleList = middlecheckDao.queryListByGroupid(1);
        }else {
            middleList = middlecheckDao.queryListByGroupid(groupid+1);
        }

        return middleList;
    }
}
