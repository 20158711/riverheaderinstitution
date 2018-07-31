package org.wingstudio.riverheaderinstitution.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import org.wingstudio.riverheaderinstitution.common.ResponseCode;
import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Random;

@Slf4j
public class FileUtil {

    public static final char[] RESOURCE = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String fileUploadPath="H:\\file";

    public static String fileDownloadPrefix="http://localhost/file/downloadFile";

    private static String pictureUploadPath="H:\\pic";

    private static String pictureDownloadPrefix="http://localhost/file/downloadPic";


    public static final String LOG_PRE = "org.wingstudio.riverheaderinstitution.controller.FileUtil:";

    /**
     * 上传文件工具 suffixName 是文件的后缀名如：.doc  .xls
     * @param file
     * @param basePath  文件上传基路径
     * @param path      文件上传用户路径
     * @param downloadPrefix
     * @param fileName
     * @param suffixName
     * @return
     */
    public static ServerResponse<String> upload(MultipartFile file, String basePath,String path,String downloadPrefix, String fileName, String suffixName) {
        String uploadPath=basePath;
        if (file == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.FILE_NOT_NULL);
        }
        if (basePath == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.PATH_NOT_NULL);
        }
        if (path != null && path.length()!=0) {
            uploadPath=basePath+File.separator+path;
        }
        log.info(LOG_PRE + "path: " + basePath);
        if (fileName == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.FILE_NAME_NOT_NULL);
        }
        log.info(LOG_PRE + "fileName: " + fileName);
        File parent = new File(uploadPath);
        if (!parent.exists()) {
            parent.mkdirs();
        }
        File dest = new File(uploadPath + File.separator + fileName + suffixName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            log.error(LOG_PRE + e.getMessage());
            return ServerResponse.createByErrorMsg(e.getMessage());
        }
        String downloadPath=downloadPrefix+"?fileName="+fileName+suffixName;
        if (path!=null && path.length()!=0)
            downloadPath=downloadPath+"&path="+path;
        log.info(LOG_PRE+"downloadPath:{}",downloadPath);
        return ServerResponse.createBySuccess(downloadPath);
    }

    /**
     * 下载文件工具 suffixName 是文件的后缀名如：.doc  .xls
     *
     * @param path
     * @param fileName
     * @return
     */
    public static ServerResponse<String> download(HttpServletResponse response, String basePath,String path, String fileName) {
        if (basePath == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.PATH_NOT_NULL);
        }
        log.info(LOG_PRE + "path: " + path);
        if (fileName == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.FILE_NAME_NOT_NULL);
        }
        log.info(LOG_PRE + "fileName: " + fileName);
        String downloadPath=basePath;
        if(path!=null && path.length()!=0){
            String replace="";
            if(File.separator.equals("\\")){
                replace = path.replace('/', File.separatorChar);
            }
            if(File.separator.equals("/")){
                replace=path.replace('\\',File.separatorChar);
            }
            downloadPath=downloadPath+File.separator+replace;
        }
        File file = new File(downloadPath + File.separator + fileName);
        if (!file.exists()) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.FILE_NOT_NULL);
        }
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            return ServerResponse.createByErrorMsg("下载文件出错");
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ServerResponse.createBySuccess();
    }

    /**
     * 上传文件
     *
     * @param file       不加:  /
     * @param path
     * @param suffixName
     * @return
     */
    public static ServerResponse<String> fileUpload(MultipartFile file, String path, String suffixName) {
        return upload(file, fileUploadPath,path, fileDownloadPrefix, getRandomFilName(), suffixName);
    }

    /**
     * 上传图片
     *
     * @param file
     * @param path
     * @param suffixName
     * @return
     */
    public static ServerResponse<String> pictureUpload(MultipartFile file, String path, String suffixName) {
        return upload(file, pictureUploadPath , path, pictureDownloadPrefix, getRandomFilName(), suffixName);
    }

    /**
     * 文件下载
     *
     * @param response
     * @param fileName
     * @return
     */
    public static ServerResponse<String> fileDownload(HttpServletResponse response,String path, String fileName) {
        return download(response, fileUploadPath,path, fileName);
    }

    /**
     * 图片下载
     *
     * @param response
     * @param fileName
     * @return
     */
    public static ServerResponse<String> pictureDownload(HttpServletResponse response, String path,String fileName) {
        return download(response, pictureUploadPath,path, fileName);
    }

    /**
     * 生成随机的文件名
     *
     * @return
     */
    public static String getRandomFilName() {
        String curr = String.valueOf(System.currentTimeMillis());
        StringBuffer buffer = new StringBuffer(curr);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            buffer.append(RESOURCE[random.nextInt(36)]);
        }
        return buffer.toString();
    }

}
