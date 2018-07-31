package org.wingstudio.riverheaderinstitution.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.wingstudio.riverheaderinstitution.common.FileUtilResponse;
import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.util.FileUtil;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;


@RestController
@Slf4j
@RequestMapping("/file")
public class FileController {

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public FileUtilResponse uploadFile(@RequestParam("file") MultipartFile file,
                                       @RequestParam(name = "path",required = false)String path){
        if (file == null) {
            return FileUtilResponse.error();
        }
        String fileName = file.getOriginalFilename();
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
        ServerResponse<String> response = FileUtil.fileUpload(file, path, suffixName);
        if (response.isSuccess()){
            return FileUtilResponse.success(Arrays.asList(response.getData()));
        }
        return FileUtilResponse.error();
    }

    @RequestMapping(value = "/downloadFile")
    public void downloadFile(HttpServletResponse response,
                                               @RequestParam("fileName")String fileName,
                                               @RequestParam(value = "path",required = false)String path){
        FileUtil.fileDownload(response, path,fileName);
    }

    @RequestMapping(value = "/uploadPic")
    public FileUtilResponse  uploadPic(@RequestParam("file") MultipartFile file,
                                            @RequestParam(name = "path",required = false)String path){
        if (file == null) {
            return FileUtilResponse.error();
        }
        String fileName = file.getOriginalFilename();
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
        ServerResponse<String> response = FileUtil.pictureUpload(file, path, suffixName);
        if (response.isSuccess()){
            return FileUtilResponse.success(Arrays.asList(response.getData()));
        }
        return FileUtilResponse.error();
    }

    @RequestMapping(value = "/downloadPic")
    public void downloadPic(HttpServletResponse response,
                                               @RequestParam("fileName")String fileName,
                                               @RequestParam(value = "path",required = false)String path){
        FileUtil.pictureDownload(response, path,fileName);
    }

}
