package com.xingong.bishe.action;

import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.GetUuid;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.dao.SelectManageDao;
import com.xingong.bishe.entitys.*;
import com.xingong.bishe.services.CollegeService;
import com.xingong.bishe.services.SelectManageService;
import com.xingong.bishe.services.TopicService;
import com.xingong.bishe.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课题相关的接口
 */

@Controller
@RequestMapping(value = "/topic/")
public class TopicAction {

    @Autowired
    TopicService topicService;

    @Autowired
    SelectManageService selectManageService;

    @Autowired
    SelectManageDao selectManageDao;

    @Autowired
    UserService userService;

    @Autowired
    CollegeService collegeService;

    Logger logger = Logger.getLogger(TopicAction.class);

    /**
     * 保存课题
     * topicid使用的uuid产生的唯一码
     *
     * @param topicEntity
     * @return
     */
    @RequestMapping(value = "savetopic", method = {RequestMethod.POST,RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResponse savetopic(@RequestBody TopicEntity topicEntity) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            topicEntity.setTopicid(GetUuid.getId());
            topicEntity.setTopicstate(0);
            topicService.saveTopic(topicEntity);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("提交成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("保存课题异常！");
        }
        return baseResponse;
    }

    /**
     * 管理员审批课题是否通过
     * topicstate 0待审批，1审批通过，-1审核未通过重新修改
     *
     * @param topicid
     * @param topicstate
     * @return
     */
    @RequestMapping(value = "check", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse check(String topicid, int topicstate) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            topicService.updateState(topicstate, topicid);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("审批成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("审批异常！");
        }
        return baseResponse;
    }

    /**
     * 分页查询课题
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "list", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse list(@RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "15") int size,
                             @RequestParam(value = "userid", required = false, defaultValue = "") String userid) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            Sort sort = new Sort(Sort.Direction.DESC, "createtime");
            Pageable pageable = new PageRequest(page, size, sort);
            Page<TopicEntity> topicList = topicService.findAllByPage(userid, pageable);
            if (topicList == null){
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
                baseResponse.setMessage("该老师没有课题！");
            }else {
                baseResponse.setData(topicList);
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
     * 学生选题操作接口
     *
     * @param userid
     * @param topicid
     * @return
     */
    @RequestMapping(value = "select", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse select(String userid, String topicid) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            SelectManageEntity selectManageEntity = selectManageService.queryById(userid);
            if (selectManageEntity != null) {
                if (selectManageEntity.getSelectIspass() == 1){
                    baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
                    baseResponse.setMessage("已经选题成功！");
                }else {
                    baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
                    baseResponse.setMessage("已经选题，在审核！");
                }
                return baseResponse;
            } else if (topicService.selectTopic(topicid)) {
                SelectManageEntity selectEntity = new SelectManageEntity();
                UserEntity userEntity = userService.getUserById(userid);
                selectEntity.setStudentid(userid);
                selectEntity.setStudentname(userEntity.getUsername());
                selectEntity.setMajor(userEntity.getMajor());
                selectEntity.setStudentphone(userEntity.getUserphone());
                selectEntity.setTopicid(topicid);
                selectEntity.setSelectIspass(0);
                selectManageDao.save(selectEntity);
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
                baseResponse.setMessage("选题成功！");
                return baseResponse;
            } else {
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
                baseResponse.setMessage("该课题人数已满！");
                return baseResponse;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("选题异常！");
            return baseResponse;
        }
    }

    /**
     * 查询学院列表
     * @return
     */
    @RequestMapping(value = "college",method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse college(){
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<CollegeEntity> collegeList = collegeService.queryAllCollege();
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setData(collegeList);
            baseResponse.setMessage("查询学院列表成功！");
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("查询异常！");
        }
        return baseResponse;
    }

    @RequestMapping(value = "major",method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse major(int collegeid ){
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<MajorEntity> majorList = collegeService.queryAllMajor(collegeid);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setData(majorList);
            baseResponse.setMessage("查询专业列表成功！");
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("查询异常！");
        }
        return baseResponse;
    }

}
