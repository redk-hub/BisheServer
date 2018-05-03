package com.xingong.bishe.action;

import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.services.OpenManageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhang on 2018/4/26.
 */
@Controller
@RequestMapping("open")
public class OpenManageAction {

    @Autowired
    OpenManageService openService;

    Logger logger = Logger.getLogger(OpenManageAction.class);

    /**
     * 上传开题报告
     */
    @RequestMapping(value = "uploadreport", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse uploadreport(String studentid, String filename) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            openService.uploadReport(studentid,filename);
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
     * 设置开题报告是否通过
     * ispass = 0 不通过，1是通过
     */
    @RequestMapping(value = "reportispass", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse setIsPass(String studentid, int ispass) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            openService.setReportIsPass(studentid,ispass);
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
     * 上传文献综述
     */
    @RequestMapping(value = "uploadwenxin", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse uploadwenxin(String studentid, String filename) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            openService.uploadWinxin(studentid,filename);
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
     * 设置文献综述是否通过
     * ispass = 0 不通过，1是通过
     */
    @RequestMapping(value = "wenxianispass", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse wenxianIspass(String studentid, int ispass) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            openService.setWinxianIsPass(studentid,ispass);
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
}
