package com.xingong.bishe.services;

import com.xingong.bishe.dao.StuTopicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhang on 2018/4/26.
 */

@Service
@Transactional
public class StuTopicService {

    @Autowired
    StuTopicDao stuTopicDao;

    /**
     * 查询进行到哪个模块了
     * 返回false时是未进行到相关模块
     * @param studentid
     * @param process
     * @return
     */
    public boolean queryProcess(String studentid,int process){
        int temp = stuTopicDao.queryProcess(studentid);
        if (temp == process){
            return true;
        }else {
            return false;
        }
    }

    public void setProcess(String studentid,int process){
        stuTopicDao.setProcess(process,studentid);
    }

}
