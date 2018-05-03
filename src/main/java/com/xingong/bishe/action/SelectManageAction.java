package com.xingong.bishe.action;

import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.dao.SelectManageDao;
import com.xingong.bishe.dao.StuTopicDao;
import com.xingong.bishe.entitys.SelectManageEntity;
import com.xingong.bishe.entitys.StuTopicEntity;
import com.xingong.bishe.services.SelectManageService;
import com.xingong.bishe.services.StuTopicService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 选题管理模块接口
 * 包括,老师确认学生选题，下发和查看任务书，
 */

@Controller
@RequestMapping(value = "/select/")
public class SelectManageAction {

    @Autowired
    SelectManageService selectManageService;

    @Autowired
    SelectManageDao selectManageDao;

    @Autowired
    StuTopicDao stuTopicDao;

    @Autowired
    StuTopicService stuTopicService;


    Logger logger = Logger.getLogger(SelectManageAction.class);

    /**
     * 老师确认学生选题
     *
     * @param studentid
     * @param ispass
     * @return
     */
    @RequestMapping(value = "confirm", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse check(String studentid, int ispass) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            selectManageService.confirmSelect(studentid, ispass);
            if (ispass == 1) {//审核通过，添加一条记录
                SelectManageEntity selectManageEntity = selectManageService.queryById(studentid);
                StuTopicEntity stuTopicEntity = new StuTopicEntity();
                stuTopicEntity.setStudentid(studentid);
                stuTopicEntity.setTopicid(selectManageEntity.getTopicid());
                stuTopicEntity.setDesignprocess(1);
                stuTopicDao.save(stuTopicEntity);
            }
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("已审核！");
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("审核异常！");
            return baseResponse;
        }
    }

    /**
     * 老师下发任务书时打开下一个模块
     */
    @RequestMapping(value = "write_taskbook", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public BaseResponse writeTaskbook(@RequestBody SelectManageEntity param) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            //保存任务书名字到表中的路径字段
            SelectManageEntity selectManageEntity = selectManageService.queryById(param.getStudentid());
            selectManageEntity.setTaskbookPath(param.getTaskbookPath());
            selectManageEntity.setTaskbookContent(param.getTaskbookContent());
            selectManageEntity.setTaskbookTechnology(param.getTaskbookTechnology());
            selectManageEntity.setTaskbookProcess(param.getTaskbookProcess());
            selectManageDao.save(selectManageEntity);
            //进入开题管理
            stuTopicService.setProcess(param.getStudentid(),2);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("任务书下发成功，进入开题管理！");
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("任务书下发失败"+e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("任务书下发失败！");
            return baseResponse;
        }
    }

    /**
     * 学生查看任务书
     */
    @RequestMapping(value = "see_taskbook", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse seeTaskbook(String studentid) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            SelectManageEntity selectManageEntity = selectManageService.queryById(studentid);
            baseResponse.setData(selectManageEntity);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("任务书查看成功，进入开题管理！");
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查看任务书异常"+e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("查看任务书！");
            return baseResponse;
        }
    }

}
