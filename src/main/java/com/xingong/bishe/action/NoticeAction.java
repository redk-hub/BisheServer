package com.xingong.bishe.action;

import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.GetUuid;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.dao.NoticeDao;
import com.xingong.bishe.entitys.NoticeEntity;
import com.xingong.bishe.entitys.TopicEntity;
import com.xingong.bishe.services.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public BaseResponse query(@RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "15") int size){
        BaseResponse baseResponse = new BaseResponse();
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "createtime");
            Pageable pageable = new PageRequest(page, size, sort);
            Page<NoticeEntity> noticeList =noticeDao.findAll(pageable);
            if (noticeList.getContent().size() == 0){
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
                baseResponse.setMessage("没有公告！");
            }else {
                baseResponse.setData(noticeList);
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
                baseResponse.setMessage("查询成功！");
            }


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
