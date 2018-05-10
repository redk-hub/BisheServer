package com.xingong.bishe.action;

import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.dao.ScoreDao;
import com.xingong.bishe.entitys.DefenceManageEntity;
import com.xingong.bishe.entitys.ScoreManageEntity;
import com.xingong.bishe.services.ScoreService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhang on 2018/5/10.
 */
@Controller
@RequestMapping(value = "/score/")
public class ScoreAction {

    @Autowired
    ScoreService scoreService;

    Logger logger = Logger.getLogger(ScoreAction.class);

    /**
     * 学生查询自己的成绩信息
     * @param studentid
     * @return
     */
    @RequestMapping(value = "query", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse query(String studentid) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            ScoreManageEntity scoreManageEntity = scoreService.query(studentid);
            baseResponse.setData(scoreManageEntity);
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
     * 成绩管理的列表，老师用到
     *
     * @param page
     * @param size
     * @param teacherid
     * @return
     */
    @RequestMapping(value = "scorelist", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse successlist(@RequestParam(value = "page", defaultValue = "0") int page,
                                    @RequestParam(value = "size", defaultValue = "15") int size,
                                    @RequestParam(value = "teacherid", required = false, defaultValue = "") String teacherid) {
        BaseResponse baseResponse = new BaseResponse();

        try {
//            Sort sort = new Sort(Sort.Direction.DESC, "createtime");
            Pageable pageable = new PageRequest(page, size);
            Page<ScoreManageEntity> scoreList = scoreService.findAllByPage(teacherid, pageable);
            if (scoreList.getContent().size() == 0) {
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
                baseResponse.setMessage("没有进行到成绩管理的学生！");
            } else {
                baseResponse.setData(scoreList);
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

    @RequestMapping(value = "commit", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse commit(@RequestBody ScoreManageEntity param) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            scoreService.commitScore(param);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("提交成功！");


        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("提交异常！");
        }
        return baseResponse;
    }


}
