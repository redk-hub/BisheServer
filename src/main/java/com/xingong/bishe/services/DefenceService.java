package com.xingong.bishe.services;

import com.xingong.bishe.dao.DefenceDao;
import com.xingong.bishe.entitys.DefenceManageEntity;
import com.xingong.bishe.entitys.OpenManageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by zhang on 2018/5/10.
 */
@Service
@Transactional
public class DefenceService {

    @Autowired
    DefenceDao defenceDao;

    public DefenceManageEntity query(String studentid){
        return defenceDao.queryByStuid(studentid);
    }
    //添加论文初稿路径
    public void setDraftPath(String studentid,String filename){
        DefenceManageEntity defenceManageEntity = defenceDao.queryByStuid(studentid);
        defenceManageEntity.setPaperdraftPath(filename);
        defenceDao.save(defenceManageEntity);
    }

    //添加论文定稿路径
    public void setFinalPath(String studentid,String filename){
        DefenceManageEntity defenceManageEntity = defenceDao.queryByStuid(studentid);
        defenceManageEntity.setPaperfinalPath(filename);
        defenceDao.save(defenceManageEntity);
    }

    //获取论文题目
    public String getTopicname(String studentid){
        DefenceManageEntity defenceManageEntity = defenceDao.queryByStuid(studentid);
        String topicname = defenceManageEntity.getTopicname();
        return topicname;
    }

    //分页查询老师所带的学生
    public Page<DefenceManageEntity> findAllByPage(String teacherid, Pageable pageable){
        if (teacherid.equals("")){
            return defenceDao.findAll(pageable);
        }else {
            return defenceDao.querydefencePage(teacherid,pageable);
        }
    }

    public void setDraftIsPass(String studentid,int ispass,String suggest){
        DefenceManageEntity defenceManageEntity = defenceDao.queryByStuid(studentid);
        defenceManageEntity.setPaperdraftIspass(ispass);
        defenceManageEntity.setPaperdraftSuggest(suggest);
        defenceDao.save(defenceManageEntity);
    }

    public void setFinalIsPass(String studentid,int ispass,String suggest){
        DefenceManageEntity defenceManageEntity = defenceDao.queryByStuid(studentid);
        defenceManageEntity.setPaperfinalIspass(ispass);
        defenceManageEntity.setPaperfinalSuggest(suggest);
        defenceDao.save(defenceManageEntity);
    }

    public void setDefenceTime(String studentid,Date time,String location){
        DefenceManageEntity defenceManageEntity = defenceDao.queryByStuid(studentid);
        defenceManageEntity.setDefenceTime(time);
        defenceManageEntity.setDefenceLocation(location);
    }
}
