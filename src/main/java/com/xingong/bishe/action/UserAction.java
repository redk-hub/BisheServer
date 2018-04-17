package com.xingong.bishe.action;

import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.entitys.UserEntity;
import com.xingong.bishe.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 与用户相关的接口
 */
@Controller
@RequestMapping(value = "/user/")
public class UserAction {

    @Autowired
    UserService userService;
    //打印log
    Logger logger = Logger.getLogger(UserAction.class);

    @RequestMapping(value = "login",method = {RequestMethod.GET},produces = {"application/json;charset=UTF-8" })
    @ResponseBody
    public BaseResponse login(String userid, String password){

        BaseResponse baseResponse = new BaseResponse();

        try {
            UserEntity userInfo = userService.getUserById(userid);
            if (userInfo != null && password.equals(userInfo.getUserpassword())){
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
                baseResponse.setMessage("登录成功！");
            }else {
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
                baseResponse.setMessage("账号或者密码错误！");
            }
        }catch (Exception e){
            e.printStackTrace();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("登录异常！");
            logger.error(e.getMessage());
        }
        return baseResponse;
    }

}
