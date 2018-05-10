package com.xingong.bishe.action;

import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.GetUuid;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.dao.NoticeDao;
import com.xingong.bishe.entitys.NoticeEntity;
import com.xingong.bishe.services.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    NoticeDao noticeDao;
    @RequestMapping(value = "query",method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse query(){
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<NoticeEntity> noticeEntityList =noticeService.queryNotice();
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

    /**
     * 添加公告
     * @param param
     * @return
     */
    @RequestMapping(value = "insert",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public BaseResponse insert(@RequestBody NoticeEntity param){
        BaseResponse baseResponse = new BaseResponse();
        try {
            String noticeid = GetUuid.getId();
            param.setNoticid(noticeid);
            noticeDao.save(param);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("添加公告成功！");

        }catch (Exception e){
            e.printStackTrace();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("添加公告异常！");
        }
        return baseResponse;
    }

    /**
     * 删除公告
     * @param noticeid
     * @return
     */
    @RequestMapping(value = "delete",method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse delete(String noticeid){
        BaseResponse baseResponse = new BaseResponse();
        try {

            noticeDao.delete(noticeid);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("删除公告成功！");

        }catch (Exception e){
            e.printStackTrace();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("删除公告异常！");
        }
        return baseResponse;
    }
}
