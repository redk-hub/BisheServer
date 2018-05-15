package com.xingong.bishe.action;

import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.MyFileUtil;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.dao.SelectManageDao;
import com.xingong.bishe.dao.StuTopicDao;
import com.xingong.bishe.entitys.SelectManageEntity;
import com.xingong.bishe.entitys.StuTopicEntity;
import com.xingong.bishe.entitys.TopicEntity;
import com.xingong.bishe.services.OpenManageService;
import com.xingong.bishe.services.SelectManageService;
import com.xingong.bishe.services.StuTopicService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

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

    @Autowired
    OpenManageService openService;


    Logger logger = Logger.getLogger(SelectManageAction.class);


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
                             @RequestParam(value = "teacherid", required = false, defaultValue = "") String teacherid) {
        BaseResponse baseResponse = new BaseResponse();

        try {
//            Sort sort = new Sort(Sort.Direction.DESC, "createtime");
            Pageable pageable = new PageRequest(page, size);
            Page<SelectManageEntity> selectList = selectManageService.findAllByPage(teacherid, pageable);
            if (selectList.getContent().size() == 0){
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
                baseResponse.setMessage("没有选择的学生！");
            }else {
                baseResponse.setData(selectList);
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
     * 分页查询选题成功课题
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "successlist", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse successlist(@RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "15") int size,
                             @RequestParam(value = "teacherid", required = false, defaultValue = "") String teacherid) {
        BaseResponse baseResponse = new BaseResponse();

        try {
//            Sort sort = new Sort(Sort.Direction.DESC, "createtime");
            Pageable pageable = new PageRequest(page, size);
            Page<SelectManageEntity> selectList = selectManageService.findSuccssByPage(teacherid, pageable);
            if (selectList.getContent().size() == 0){
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
                baseResponse.setMessage("没有审核成功的学生！");
            }else {
                baseResponse.setData(selectList);
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
            selectManageService.setTaskbookContent(param);
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
            baseResponse.setMessage("查看任务书异常！");
            return baseResponse;
        }
    }


    /**
     * 学生确认任务书
     */
    @RequestMapping(value = "confirm_taskbook", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse confirmTaskbook(String studentid) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            SelectManageEntity selectManageEntity = selectManageService.queryById(studentid);
            selectManageEntity.setTaskbookIsconfirm(1);
            selectManageDao.save(selectManageEntity);

            openService.insert(selectManageEntity);
            baseResponse.setData(selectManageEntity.getTaskbookIsconfirm());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("任务确认成功，进入开题管理！");
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("确认任务书异常"+e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("确认任务书异常！");
            return baseResponse;
        }
    }

    /**
     * 上传任务书文件
     * @param request
     * @param topicname
     * @param file
     * @return
     * @throws Exception
     */
    //上传文件会自动绑定到MultipartFile中
    @RequestMapping(value="upload",method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public BaseResponse upload(HttpServletRequest request,
                               @RequestParam("topicname") String topicname,
                               @RequestBody MultipartFile file) throws Exception {

        BaseResponse baseResponse = new BaseResponse();
        //保存文件，获取文件名称，保存到数据库
        String filename = MyFileUtil.getUploadFilename(request,topicname,file);
        if (filename == null){
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("上传文件为空！");
        }else {
            selectManageService.setTaskpath(topicname,filename);
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            baseResponse.setMessage("上传文件成功!");
        }

        return baseResponse;
    }



}
