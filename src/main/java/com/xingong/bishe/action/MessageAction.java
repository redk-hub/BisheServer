package com.xingong.bishe.action;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.GetUuid;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.dao.MessageDao;
import com.xingong.bishe.entitys.MessageEntity;
import com.xingong.bishe.entitys.NoticeEntity;
import com.xingong.bishe.entitys.TopicEntity;
import com.xingong.bishe.services.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/5/10.
 */
@Controller
@RequestMapping(value = "/message/")
public class MessageAction {

    @Autowired
    MessageDao messageDao;
    @Autowired
    MessageService messageService;

    Logger logger = Logger.getLogger(MessageAction.class);

    @RequestMapping(value = "insert", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public BaseResponse insert(@RequestBody MessageEntity param) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            String messageid = GetUuid.getId();
            param.setMessageid(messageid);
            messageDao.save(param);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("添加留言成功！");

        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("添加留言异常！");
        }
        return baseResponse;
    }

    /**
     * 查询接收者的留言
     * @param page
     * @param size
     * @param receiverid
     * @param state
     * @return
     */
    @RequestMapping(value = "receiverquery", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse query(@RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "15") int size,
                              @RequestParam(value = "receiverid", required = false, defaultValue = "") String receiverid,
                              @RequestParam(value = "state", required = false, defaultValue = "") int state) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "createtime");
            Pageable pageable = new PageRequest(page, size, sort);
            Page<MessageEntity> messageList = messageService.queryReceiveByState(receiverid,state, pageable);
            if (messageList.getContent().size() == 0){
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
                baseResponse.setMessage("您没有留言！");
            }else {
                baseResponse.setData(messageList);
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
                baseResponse.setMessage("留言查询成功！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("查询异常！");
        }
        return baseResponse;
    }


    /**
     * 获取发送者的列表
     * @param page
     * @param size
     * @param senderid
     * @param state
     * @return
     */
    @RequestMapping(value = "senderquery", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse senderquery(@RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "15") int size,
                              @RequestParam(value = "senderid", required = false, defaultValue = "") String senderid,
                              @RequestParam(value = "state", required = false, defaultValue = "") int state) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "createtime");
            Pageable pageable = new PageRequest(page, size, sort);
            Page<MessageEntity> messageList = messageService.querySendByState(senderid,state, pageable);
            if (messageList.getContent().size() == 0){
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
                baseResponse.setMessage("您没有发送留言！");
            }else {
                baseResponse.setData(messageList);
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
                baseResponse.setMessage("留言查询成功！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("查询异常！");
        }
        return baseResponse;
    }

    /**
     * 设置状态
     * @param messageids
     * @param state
     * @return
     */
    @RequestMapping(value = "setstate", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public BaseResponse setState(@RequestBody String messageids , int state) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            Gson gson = new Gson();
            List<String> idList = gson.fromJson(messageids, new TypeToken<List<String>>() {
            }.getType());

            for (String messageid:idList){
                messageService.setState(messageid,state);
            }
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("状态修改成功！");

        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("状态修改异常！");
        }
        return baseResponse;
    }
}
