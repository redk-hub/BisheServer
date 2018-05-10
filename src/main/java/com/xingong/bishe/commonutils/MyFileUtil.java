package com.xingong.bishe.commonutils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by zhang on 2018/5/5.
 */
public class MyFileUtil {


    /**
     * 获取上传文件的名称，如果文件为空，返回null
     * @param request
     * @param topicname
     * @param file
     * @return
     * @throws Exception
     */
    public static String getUploadFilename(HttpServletRequest request,
                               String topicname,
                               MultipartFile file) throws Exception {

        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/files/"+topicname+"/");
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return filename;

        } else {
            return null;
        }

    }
}
