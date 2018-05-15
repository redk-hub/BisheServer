package com.xingong.bishe.services;

import com.xingong.bishe.dao.OpenManageDao;
import com.xingong.bishe.dao.SelectManageDao;
import com.xingong.bishe.entitys.OpenManageEntity;
import com.xingong.bishe.entitys.SelectManageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhang on 2018/4/26.
 */
@Service
@Transactional
public class OpenManageService {
    @Autowired
    OpenManageDao openManageDao;
    @Autowired
    SelectManageDao selectManageDao;


    public List<OpenManageEntity> queryOpenList(String studentid){
        return openManageDao.queryListById(studentid);
    }


    public Page<OpenManageEntity> findAllByPage(String teacherid, Pageable pageable){
        if (teacherid.equals("")){
            return openManageDao.findAll(pageable);
        }else {
            return openManageDao.queryOpenPage(teacherid,pageable);
        }
    }
    /**
     * 上传开题报告
     * 如果有studentid的信息就保存，没有就新建
     */
    public void uploadReport(String studentid,String filename){
        OpenManageEntity openManageEntity = openManageDao.queryById(studentid);
            openManageEntity.setOpenreportPath(filename);
            openManageEntity.setOpenreportIspass(0);
            openManageDao.save(openManageEntity);

    }

    /**
     * 设置开题报告是否通过
     * @param studentid
     * @param ispass
     */
    public void setReportIsPass(String studentid,int ispass,int score,String suggest){
        OpenManageEntity openManageEntity = openManageDao.queryById(studentid);
        openManageEntity.setOpenreportIspass(ispass);
        openManageEntity.setOpenreportScore(score);
        openManageEntity.setOpenreportSuggest(suggest);
        openManageDao.save(openManageEntity);
    }

    /**
     * 上传文献综述
     * 如果有studentid的信息就保存，没有就新建
     */
    public void uploadWinxian(String studentid,String filename){

            OpenManageEntity openEntity = openManageDao.queryById(studentid);

            openEntity.setWenxianPath(filename);
            openEntity.setWenxianIspass(0);
            openManageDao.save(openEntity);

    }

    /**
     * 下发任务书后往开题管理表里添加基本信息
     * @param selectManageEntity
     */
    public void insert(SelectManageEntity selectManageEntity){
        OpenManageEntity openEntity = new OpenManageEntity();
        openEntity.setStudentid(selectManageEntity.getStudentid());
        openEntity.setStudentname(selectManageEntity.getStudentname());
        openEntity.setTopicname(selectManageEntity.getTopicname());
        openEntity.setTeacherid(selectManageEntity.getTeacherid());
        openEntity.setTeachername(selectManageEntity.getTeachername());
        openManageDao.save(openEntity);
    }


    /**
     * 设置文献报告是否通过
     * @param studentid
     * @param ispass
     */
    public void setWinxianIsPass(String studentid,int ispass,int score,String suggest){
        OpenManageEntity openManageEntity = openManageDao.queryById(studentid);
        openManageEntity.setWenxianIspass(ispass);
        openManageEntity.setWenxianScore(score);
        openManageEntity.setWenxianSuggest(suggest);
        openManageDao.save(openManageEntity);
    }


    /**
     * 获取课题名称
     * @param studentid
     * @return
     */
    public String getTopicname(String studentid){
        return selectManageDao.getTopicname(studentid);
    }



    public OpenManageEntity queryOpenById(String studentid){
        return openManageDao.queryById(studentid);
    }
}
