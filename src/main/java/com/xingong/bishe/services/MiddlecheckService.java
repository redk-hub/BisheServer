package com.xingong.bishe.services;

import com.xingong.bishe.dao.MiddlecheckDao;
import com.xingong.bishe.entitys.DefenceManageEntity;
import com.xingong.bishe.entitys.GroupEntity;
import com.xingong.bishe.entitys.MiddlecheckManageEntity;
import com.xingong.bishe.entitys.SelectManageEntity;
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
public class MiddlecheckService {

    @Autowired
    MiddlecheckDao middlecheckDao;


    public List<MiddlecheckManageEntity> queryMiddleList(String teacherid){
        return middlecheckDao.queryListByTeacherid(teacherid);
    }

    //管理员查看分组信息
    public List<GroupEntity> queryGroupList(){
        List<GroupEntity> grouplist = new ArrayList<GroupEntity>();
        for(int i=0;i<5;i++){
            GroupEntity groupEntity = new GroupEntity();
            groupEntity.setGroupid(i+1);
            List<MiddlecheckManageEntity> defencelist = middlecheckDao.queryGroupByGroupid(i+1);
            List<String> namelist = new ArrayList<String>();
            for (MiddlecheckManageEntity middleEntity : defencelist){
                String teachername = middleEntity.getTeachername();
                namelist.add(teachername);
            }
            groupEntity.setGrouplist(namelist);
            grouplist.add(groupEntity);
        }
        return grouplist;
    }
    //第一组导师检查第二组导师的学生，第五组检查第一组
    public List<MiddlecheckManageEntity> queryCheckGroup(String teacherid){

        List<Integer> groupids = middlecheckDao.queryGroupidByTeacherid(teacherid);
        int groupid = 0;
        if (groupids.size() != 0 ){
            groupid = groupids.get(0);
        }
        List<MiddlecheckManageEntity> middleList;
        if (groupid == 5){
            middleList = middlecheckDao.queryListByGroupid(1);
        }else {
            middleList = middlecheckDao.queryListByGroupid(groupid+1);
        }

        return middleList;
    }

    //查询自己所带学生的中检信息
    public Page<MiddlecheckManageEntity> findMystudentByPage(String teacherid, Pageable pageable){
        return middlecheckDao.queryMystudentPage(teacherid,pageable);
    }

    public List<String> getCheckTeacher(String studentid){
        int groupid = middlecheckDao.queryGroupidByStuid(studentid);
        List<String> nameList ;
        if (groupid == 1){
            nameList = middlecheckDao.queryTeacherByGroupid(5);
        }else {
            nameList = middlecheckDao.queryTeacherByGroupid(groupid-1);
        }
        return nameList;
    }


}
