package com.xingong.bishe.action;

import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.MyFileUtil;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.dao.ScoreDao;
import com.xingong.bishe.entitys.DefenceManageEntity;
import com.xingong.bishe.entitys.MiddlecheckManageEntity;
import com.xingong.bishe.entitys.OpenManageEntity;
import com.xingong.bishe.entitys.ScoreManageEntity;
import com.xingong.bishe.services.DefenceService;
import com.xingong.bishe.services.StuTopicService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by zhang on 2018/5/10.
 */
@Controller
@RequestMapping(value = "defence")
public class DefenceAction {

    @Autowired
    DefenceService defenceService;

    @Autowired
    StuTopicService stuTopicService;

    @Autowired
    ScoreDao scoreDao;

    Logger logger = Logger.getLogger(DefenceAction.class);


    /**
     * 学生查询自己的答辩信息
     * @param studentid
     * @return
     */
    @RequestMapping(value = "query", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse query(String studentid) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            DefenceManageEntity defenceManageEntity = defenceService.query(studentid);
            baseResponse.setData(defenceManageEntity);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("查询成功！");


        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("查询异常！");
        }
        return baseResponse;
    }

    /**
     * 答辩管理的列表，老师用到
     *
     * @param page
     * @param size
     * @param teacherid
     * @return
     */
    @RequestMapping(value = "defencelist", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse successlist(@RequestParam(value = "page", defaultValue = "0") int page,
                                    @RequestParam(value = "size", defaultValue = "15") int size,
                                    @RequestParam(value = "teacherid", required = false, defaultValue = "") String teacherid) {
        BaseResponse baseResponse = new BaseResponse();

        try {
//            Sort sort = new Sort(Sort.Direction.DESC, "createtime");
            Pageable pageable = new PageRequest(page, size);
            Page<DefenceManageEntity> denfenceList = defenceService.findAllByPage(teacherid, pageable);
            if (denfenceList.getContent().size() == 0) {
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
                baseResponse.setMessage("没有进行到答辩的学生！");
            } else {
                baseResponse.setData(denfenceList);
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
                baseResponse.setMessage("查询成功！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("查询异常！");
        }
        return baseResponse;
    }

    /**
     * 提交论文初稿
     *
     * @param studentid
     * @return
     */
    @RequestMapping(value = "commitdraft", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResponse commitdraft(HttpServletRequest request,
                                    @RequestParam("studentid") String studentid,
                                    @RequestBody MultipartFile file) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            String topicname = defenceService.getTopicname(studentid);
            String filename = MyFileUtil.getUploadFilename(request, topicname, file);
            defenceService.setDraftPath(studentid, filename);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("上传成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("上传异常！");
        }
        return baseResponse;
    }

    /**
     * 设置论文初稿是否通过
     * ispass = 0 不通过，1是通过
     */
    @RequestMapping(value = "draftispass", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse draftIspass(String studentid, int ispass,String suggust) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            defenceService.setDraftIsPass(studentid,ispass,suggust);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("已审批！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("审批异常！");
        }
        return baseResponse;
    }

    /**
     * 提交论文定稿
     *
     * @param studentid
     * @return
     */
    @RequestMapping(value = "commitfinal", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResponse commitfinal(HttpServletRequest request,
                                    @RequestParam("studentid") String studentid,
                                    @RequestBody MultipartFile file) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            String topicname = defenceService.getTopicname(studentid);
            String filename = MyFileUtil.getUploadFilename(request, topicname, file);
            defenceService.setFinalPath(studentid, filename);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("上传成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("上传异常！");
        }
        return baseResponse;
    }

    /**
     * 设置论文定稿是否通过
     * ispass = 0 不通过，1是通过
     */
    @RequestMapping(value = "finalispass", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse finalIspass(String studentid, int ispass,String suggust) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            defenceService.setFinalIsPass(studentid,ispass,suggust);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("已审批！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("审批异常！");
        }
        return baseResponse;
    }

    /**
     * 设置答辩时间和地点
     * @param studentid
     * @param time
     * @param location
     * @return
     */
    @RequestMapping(value = "settime", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse settime(String studentid, Date time, String location) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            defenceService.setDefenceTime(studentid,time,location);

            //进入成绩管理
            stuTopicService.setProcess(studentid,5);

            //添加成绩管理数据
            DefenceManageEntity defenceManageEntity = defenceService.query(studentid);
            ScoreManageEntity scoreManageEntity = new ScoreManageEntity();
            scoreManageEntity.setStudentid(studentid);
            scoreManageEntity.setStudentname(defenceManageEntity.getStudentname());
            scoreManageEntity.setTeacherid(defenceManageEntity.getTeacherid());
            scoreManageEntity.setTopicname(defenceManageEntity.getTopicname());
            scoreManageEntity.setTopicid(defenceManageEntity.getTopicid());
            scoreDao.save(scoreManageEntity);

            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("已设置！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("设置异常！");
        }
        return baseResponse;
    }
}
