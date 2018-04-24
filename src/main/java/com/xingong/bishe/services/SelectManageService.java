package com.xingong.bishe.services;

import com.xingong.bishe.dao.SelectManageDao;
import com.xingong.bishe.entitys.SelectManageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhang on 2018/4/24.
 */

@Service
@Transactional
public class SelectManageService {

    @Autowired
    SelectManageDao selectManageDao;

    public SelectManageEntity qeyryById(String studentid){
        return selectManageDao.queryById(studentid);
    }

    /**
     * 确认学生的选题
     * @param studentid
     * @param ispass
     */
    public void confirmSelect(String studentid,int ispass){
        selectManageDao.confirmSelect(ispass,studentid);
    }
}
