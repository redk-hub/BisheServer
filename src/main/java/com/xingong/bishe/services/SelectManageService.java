package com.xingong.bishe.services;

import com.xingong.bishe.dao.SelectManageDao;
import com.xingong.bishe.entitys.SelectManageEntity;
import com.xingong.bishe.entitys.TopicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhang on 2018/4/24.
 */

@Service
@Transactional
public class SelectManageService {

    @Autowired
    SelectManageDao selectManageDao;


    /**
     * 查询所有待审核的学生选题
     * @param teacherid
     * @param pageable
     * @return
     */
    public Page<SelectManageEntity> findAllByPage(String teacherid, Pageable pageable){
        if (teacherid.equals("")){
            return selectManageDao.findAll(pageable);
        }else {
            return selectManageDao.querySelectPage(teacherid,pageable);
        }
    }

    public Page<SelectManageEntity> findSuccssByPage(String teacherid, Pageable pageable){
        return selectManageDao.querySuccessPage(teacherid,pageable);
    }



    public SelectManageEntity queryById(String studentid){
        return selectManageDao.queryById(studentid);
    }

    /**
     * 添加任务书路径，其实就是添加个文件名字
     */
    public void setTaskpath(String topicname,String filename){
        List<SelectManageEntity> selectList = selectManageDao.queryAllByTopicname(topicname);
        for (SelectManageEntity selectManageEntity : selectList){
            selectManageEntity.setTaskbookPath(filename);
            selectManageDao.save(selectManageEntity);
        }
    }

    public void setTaskbookContent(SelectManageEntity param){
        List<SelectManageEntity> selectList = selectManageDao.queryByTopicname(param.getTopicname());
        for (SelectManageEntity selectManageEntity : selectList){
            selectManageEntity.setTaskbookContent(param.getTaskbookContent());
            selectManageEntity.setTaskbookTechnology(param.getTaskbookTechnology());
            selectManageEntity.setTaskbookProcess(param.getTaskbookProcess());
            selectManageEntity.setTaskbookWenxian(param.getTaskbookWenxian());
            selectManageDao.save(selectManageEntity);
        }

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
