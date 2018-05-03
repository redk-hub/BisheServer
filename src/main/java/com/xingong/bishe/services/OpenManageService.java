package com.xingong.bishe.services;

import com.xingong.bishe.dao.OpenManageDao;
import com.xingong.bishe.entitys.OpenManageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhang on 2018/4/26.
 */
@Service
@Transactional
public class OpenManageService {
    @Autowired
    OpenManageDao openManageDao;

    /**
     * 上传开题报告
     * 如果有studentid的信息就保存，没有就新建
     */
    public void uploadReport(String studentid,String filename){
        OpenManageEntity openManageEntity = openManageDao.queryById(studentid);
        if (openManageEntity != null){
            openManageEntity.setOpenreportPath(filename);
            openManageDao.save(openManageEntity);
        }else {
            OpenManageEntity openEntity = new OpenManageEntity();
            openEntity.setStudentid(studentid);
            openEntity.setOpenreportPath(filename);
            openManageDao.save(openEntity);
        }

    }

    /**
     * 设置开题报告是否通过
     * @param studentid
     * @param ispass
     */
    public void setReportIsPass(String studentid,int ispass){
        openManageDao.setReportIsPass(ispass,studentid);
    }

    /**
     * 上传文献综述
     * 如果有studentid的信息就保存，没有就新建
     */
    public void uploadWinxin(String studentid,String filename){
        OpenManageEntity openManageEntity = openManageDao.queryById(studentid);
        if (openManageEntity != null){
            openManageEntity.setWenxianPath(filename);
            openManageDao.save(openManageEntity);
        }else {
            OpenManageEntity openEntity = new OpenManageEntity();
            openEntity.setStudentid(studentid);
            openEntity.setWenxianPath(filename);
            openManageDao.save(openEntity);
        }

    }

    /**
     * 设置开题报告是否通过
     * @param studentid
     * @param ispass
     */
    public void setWinxianIsPass(String studentid,int ispass){
        openManageDao.setWenxianIsPass(ispass,studentid);
    }

}
