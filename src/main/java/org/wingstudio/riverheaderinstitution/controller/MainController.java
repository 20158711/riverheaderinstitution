package org.wingstudio.riverheaderinstitution.controller;

import com.mysql.jdbc.util.ResultSetUtil;
import javassist.ClassClassPath;
import lombok.extern.slf4j.Slf4j;
import org.attoparser.util.TextUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.po.RiverFunction;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@Slf4j
public class MainController {

    public static String STATIC_PATH_IMG;

    static {
        File path;
        try {
            path = new File(ResourceUtils.getURL("classpath:static").getPath());
            File img=new File(path+"/img");
            if (!img.exists())
                img.mkdirs();
            STATIC_PATH_IMG=img.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Value("${custom.tmpLocation}")
    private String tmpLocation;

    @Value("${custom.destLocation}")
    private String destPath;

    @Bean
    MultipartConfigElement element() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(tmpLocation);
        return factory.createMultipartConfig();
    }

    @RequestMapping("/hello")
    public RiverFunction hello() {
        RiverFunction function = new RiverFunction();
        function.setFunction("测试用的");
        return function;
    }

    @RequestMapping("/hello1")
    public ServerResponse<RiverFunction> hello1() {
        RiverFunction function = new RiverFunction();
        function.setFunction("测试用的");
        ServerResponse<RiverFunction> bySuccess = ServerResponse.createBySuccess(function);
        return bySuccess;
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }


    @RequestMapping(value = "/uploadimage", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    public ServerResponse<String> imgUpload(@RequestParam(value = "upfile") MultipartFile file) {
        if (file.isEmpty())
            return ServerResponse.createByErrorMsg("文件不能为空");
        String fileName = file.getOriginalFilename();
        log.info("上传文件名为：{}", fileName);

        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("上传文件后缀名为：{}", suffixName);

        String filePath = STATIC_PATH_IMG;
        log.info("上传文件路径：{}", filePath);
        File dest = new File(filePath + File.separator + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return ServerResponse.createBySuccess("上传文件成功");
        } catch (IllegalStateException e) {
            return ServerResponse.createByErrorMsg(e.getMessage());
        } catch (IOException e) {
            return ServerResponse.createByErrorMsg(e.getMessage());
        }
    }



}
