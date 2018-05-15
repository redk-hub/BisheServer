package com.xingong.bishe.services;

import com.xingong.bishe.dao.DefenceDao;
import com.xingong.bishe.entitys.DefenceManageEntity;
import com.xingong.bishe.entitys.GroupEntity;
import com.xingong.bishe.entitys.MiddlecheckManageEntity;
import com.xingong.bishe.entitys.OpenManageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhang on 2018/5/10.
 */
@Service
@Transactional
public class DefenceService {

    @Autowired
    DefenceDao defenceDao;

    public List<DefenceManageEntity> querydefenceList(String teacherid){
        return defenceDao.queryListByTeacherid(teacherid);
    }

    //管理员查看分组信息
    public List<GroupEntity> queryGroupList(){
        List<GroupEntity> grouplist = new ArrayList<GroupEntity>();
        for(int i=0;i<5;i++){
            GroupEntity groupEntity = new GroupEntity();
            groupEntity.setGroupid(i+1);
            Date time = null;
            String location = "";
            List<DefenceManageEntity> defencelist = defenceDao.queryGroupByGroupid(i+1);
            List<String> namelist = new ArrayList<String>();
            for (DefenceManageEntity defenceManageEntity : defencelist){
                String teachername = defenceManageEntity.getTeachername();
                time = defenceManageEntity.getDefenceTime();
                location = defenceManageEntity.getDefenceLocation();
                namelist.add(teachername);
            }
            groupEntity.setGrouplist(namelist);
            groupEntity.setLocation(location);
            groupEntity.setTime(time);
            grouplist.add(groupEntity);
        }
        return grouplist;
    }

    //第一组导师检查第二组导师的学生，第五组检查第一组
    public Page<DefenceManageEntity> queryCheckGroup(String teacherid,Pageable pageable){

        List<Integer> groupids = defenceDao.queryGroupidByTeacherid(teacherid);
        int groupid = 0;
        if (groupids.size() != 0 ){
            groupid = groupids.get(0);
        }
        Page<DefenceManageEntity> defencePage = defenceDao.queryPageByGroupid(groupid ,pageable);
        return defencePage;
    }

    //查询自己所带学生的中检信息
    public Page<DefenceManageEntity> findMystudentByPage(String teacherid, Pageable pageable){
        return defenceDao.queryMystudentPage(teacherid,pageable);
    }

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

    public void setDefenceTime(int groupid,Date time,String location){
        List<DefenceManageEntity> defenceList = defenceDao.queryListByGroupid(groupid);
        for (DefenceManageEntity defenceManageEntity : defenceList){
            defenceManageEntity.setDefenceTime(time);
            defenceManageEntity.setDefenceLocation(location);
            defenceDao.save(defenceManageEntity);
        }

    }

    public List<DefenceManageEntity> getDefenceList(int groupid){
        return defenceDao.queryListByGroupid(groupid);
    }
}
