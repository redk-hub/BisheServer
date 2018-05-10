package com.xingong.bishe.action;

import com.google.gson.Gson;
import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.dao.DefenceDao;
import com.xingong.bishe.dao.MiddlecheckDao;
import com.xingong.bishe.entitys.DefenceManageEntity;
import com.xingong.bishe.entitys.GroupEntity;
import com.xingong.bishe.entitys.MiddlecheckManageEntity;
import com.xingong.bishe.services.MiddlecheckService;
import com.xingong.bishe.services.StuTopicService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Cacheable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2018/5/10.
 */
@Controller
@RequestMapping(value = "/middle/")
public class MiddlecheckAction {

    @Autowired
    MiddlecheckService middlecheckService;

    @Autowired
    MiddlecheckDao middlecheckDao;

    @Autowired
    StuTopicService stuTopicService;

    @Autowired
    DefenceDao defenceDao;
    Logger logger = Logger.getLogger(MiddlecheckAction.class);

    /**
     * 中检分组接口
     * @param groupEntity
     * @return
     */
    @RequestMapping(value = "group", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResponse group(@RequestBody GroupEntity groupEntity) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            int groupid = groupEntity.getGroupid();
            for (String teacherid : groupEntity.getGrouplist()){
                List<MiddlecheckManageEntity> middleList = middlecheckService.queryMiddleList(teacherid);
                for (MiddlecheckManageEntity middleEntity : middleList){
                    middleEntity.setGroupid(groupid);
                    middlecheckDao.save(middleEntity);
                }
            }
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("分组成功!");

        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("分组异常！");
        }

        return baseResponse;
    }

    /**
     * 根据老师id查询应该审查的学生
     * @param teacherid
     * @return
     */
    @RequestMapping(value = "query", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResponse query(String teacherid) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<MiddlecheckManageEntity> middleList = middlecheckService.queryCheckGroup(teacherid);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setData(middleList);
            baseResponse.setMessage("分组成功!");


        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("分组异常！");
        }

        return baseResponse;
    }

    /**
     * 根据学生id查询所在分组
     * @param studentid
     * @return
     */
    @RequestMapping(value = "studentquery", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResponse studentquery(String studentid) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            int groupid = middlecheckDao.queryGroupidByStuid(studentid);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setData(groupid);
            baseResponse.setMessage("查询成功!");


        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("查询异常！");
        }

        return baseResponse;
    }

    /**
     * 老师在评分时查询学生中检信息
     * @param studentid
     * @return
     */
    @RequestMapping(value = "queryonestu", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResponse teacherQueryStudent(String studentid) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            MiddlecheckManageEntity middleEntity = middlecheckDao.queryByStudentid(studentid);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setData(middleEntity);
            baseResponse.setMessage("查询成功!");
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("查询异常！");
        }

        return baseResponse;
    }

    /**
     * 上传中检信息，包括分数和中检报告
     * @param param
     * @return
     */
    @RequestMapping(value = "check", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResponse check(@RequestBody MiddlecheckManageEntity param) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            MiddlecheckManageEntity middleEntity = middlecheckDao.findOne(param.getStudentid());
            middleEntity.setMiddlecheckIspass(param.getMiddlecheckIspass());
            middleEntity.setMiddlecheckScore(param.getMiddlecheckScore());
            middleEntity.setMiddlecheckSuggest(param.getMiddlecheckSuggest());
            middleEntity.setMiddlereportPath(param.getMiddlereportPath());
            middlecheckDao.save(middleEntity);

            //进入答辩管理
            stuTopicService.setProcess(param.getStudentid(),4);

            //添加信息
            DefenceManageEntity defenceManageEntity = new DefenceManageEntity();
            defenceManageEntity.setStudentid(middleEntity.getStudentid());
            defenceManageEntity.setStudentname(middleEntity.getStudentname());
            defenceManageEntity.setTeacherid(middleEntity.getTeacherid());
            defenceManageEntity.setTeachername(middleEntity.getTeachername());
            defenceManageEntity.setTopicname(middleEntity.getTopicname());
            defenceDao.save(defenceManageEntity);

            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("中检信息上传成功!");


        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("中检信息上传异常！");
        }

        return baseResponse;
    }
}
