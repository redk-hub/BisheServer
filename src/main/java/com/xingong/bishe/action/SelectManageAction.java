package com.xingong.bishe.action;

import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.dao.StuTopicDao;
import com.xingong.bishe.entitys.SelectManageEntity;
import com.xingong.bishe.entitys.StuTopicEntity;
import com.xingong.bishe.services.SelectManageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    StuTopicDao stuTopicDao;

    Logger logger = Logger.getLogger(SelectManageAction.class);

    /**
     * 老师确认学生选题
     * @param studentid
     * @param ispass
     * @return
     */
    @RequestMapping(value = "confirm", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse check(String studentid,int ispass) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            selectManageService.confirmSelect(studentid,ispass);
            if (ispass == 1){//审核通过，添加一条记录
                SelectManageEntity selectManageEntity = selectManageService.qeyryById(studentid);
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
}
