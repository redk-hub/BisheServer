package com.xingong.bishe.action;

import com.xingong.bishe.commonutils.BaseResponse;
import com.xingong.bishe.commonutils.MyFileUtil;
import com.xingong.bishe.commonutils.ReturnInfo;
import com.xingong.bishe.services.StuTopicService;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by zhang on 2018/4/25.
 */

@Controller
@RequestMapping(value = "/common/")
public class CommonAction {


    @Autowired
    StuTopicService stuTopicService;
    Logger logger  = Logger.getLogger(CommonAction.class);

    /**
     * 下载报告文件
     * @param request
     * @param topicname
     * @param filename
     * @return
     * @throws Exception
     */
    @RequestMapping(value="download")
    @ResponseBody
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("topicname") String topicname,
                                           @RequestParam("filename") String filename)throws Exception {
        //下载文件路径
        String path = request.getServletContext().getRealPath("/files/"+topicname+"/");
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.OK);
    }




    /**
     * 查询毕设进行到哪个模块了
     * @param studentid
     * @param process
     * @return
     */
    @RequestMapping(value = "process", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse review(String studentid,int process) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            boolean is = stuTopicService.queryProcess(studentid,process);
            if (is){
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_OK);
            }else {
                baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
                baseResponse.setMessage("未进行到该流程！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setStatus(ReturnInfo.RESPONSE_STATUS_FAILURE);
            baseResponse.setMessage("查询进程异常！");
        }
        return baseResponse;
    }
}
