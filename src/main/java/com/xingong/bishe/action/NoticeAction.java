package com.xingong.bishe.action;

import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.entitys.NoticeEntity;
import com.xingong.bishe.services.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liekkas on 2018/5/3.
 */
@Controller
@RequestMapping(value = "/notice/")
public class NoticeAction {
    @Autowired
    NoticeService  noticeService;
    @RequestMapping(value = "query",method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse query(String userid){
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<NoticeEntity> noticeEntityList =noticeService.queryNotice(userid);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setData( noticeEntityList);
            baseResponse.setMessage("查询公告成功！");

        }catch (Exception e){
            e.printStackTrace();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("查询异常！");
        }
        return baseResponse;
    }
}
