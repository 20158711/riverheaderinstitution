package org.wingstudio.riverheaderinstitution.ueditor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class UEditorController {

    @RequestMapping("ueditor")
    public String edit(){
        return "index";
    }

    @RequestMapping(value = "/imgUploadConfig",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String config(){
                String config="{\n" +
                "    \"videoMaxSize\":102400000,\n" +
                "    \"videoActionName\":\"uploadvideo\",\n" +
                "    \"fileActionName\":\"uploadfile\",\n" +
                "    \"fileManagerListPath\":\"/ueditor/jsp/upload/file/\",\n" +
                "    \"imageCompressBorder\":1600,\n" +
                "    \"imageManagerAllowFiles\":[\n" +
                "        \".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\"\n" +
                "    ],\n" +
                "    \"imageManagerListPath\":\"/ueditor/jsp/upload/image/\",\n" +
                "    \"fileMaxSize\":51200000,\n" +
                "    \"fileManagerAllowFiles\":[\n" +
                "        \".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\",\".flv\",\".swf\",\".mkv\",\".avi\",\".rm\",\".rmvb\",\".mpeg\",\".mpg\",\".ogg\",\n" +
                "        \".ogv\",\".mov\",\".wmv\",\".mp4\",\".webm\",\".mp3\",\".wav\",\".mid\",\".rar\",\".zip\",\".tar\",\".gz\",\".7z\",\".bz2\",\n" +
                "        \".cab\",\".iso\",\".doc\",\".docx\",\".xls\",\".xlsx\",\".ppt\",\".pptx\",\".pdf\",\".txt\",\".md\",\".xml\"\n" +
                "    ],\n" +
                "    \"fileManagerActionName\":\"listfile\",\n" +
                "    \"snapscreenInsertAlign\":\"none\",\n" +
                "    \"scrawlActionName\":\"uploadscrawl\",\n" +
                "    \"videoFieldName\":\"upfile\",\n" +
                "    \"imageCompressEnable\":true,\n" +
                "    \"videoUrlPrefix\":\"\",\n" +
                "    \"fileManagerUrlPrefix\":\"\",\n" +
                "    \"catcherAllowFiles\":[\n" +
                "        \".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\"\n" +
                "    ],\n" +
                "    \"imageManagerActionName\":\"listimage\",\n" +
                "    \"snapscreenPathFormat\":\"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
                "    \"scrawlPathFormat\":\"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
                "    \"scrawlMaxSize\":2048000,\n" +
                "    \"imageInsertAlign\":\"none\",\n" +
                "    \"catcherPathFormat\":\"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
                "    \"catcherMaxSize\":2048000,\n" +
                "    \"snapscreenUrlPrefix\":\"\",\n" +
                "    \"imagePathFormat\":\"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
                "    \"imageManagerUrlPrefix\":\"\",\n" +
                "    \"scrawlUrlPrefix\":\"\",\n" +
                "    \"scrawlFieldName\":\"upfile\",\n" +
                "    \"imageMaxSize\":2048000,\n" +
                "    \"imageAllowFiles\":[\n" +
                "        \".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\"\n" +
                "    ],\n" +
                "    \"snapscreenActionName\":\"uploadimage\",\n" +
                "    \"catcherActionName\":\"catchimage\",\n" +
                "    \"fileFieldName\":\"upfile\",\n" +
                "    \"fileUrlPrefix\":\"\",\n" +
                "    \"imageManagerInsertAlign\":\"none\",\n" +
                "    \"catcherLocalDomain\":[\n" +
                "        \"127.0.0.1\",\"localhost\",\"img.baidu.com\"\n" +
                "    ],\n" +
                "    \"filePathFormat\":\"/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
                "    \"videoPathFormat\":\"/ueditor/jsp/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
                "    \"fileManagerListSize\":20,\n" +
                "    \"imageActionName\":\"uploadimage\",\n" +
                "    \"imageFieldName\":\"upfile\",\n" +
                "    \"imageUrlPrefix\":\"\",\n" +
                "    \"scrawlInsertAlign\":\"none\",\n" +
                "    \"fileAllowFiles\":[\n" +
                "        \".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\",\".flv\",\".swf\",\".mkv\",\".avi\",\".rm\",\".rmvb\",\".mpeg\",\".mpg\",\".ogg\",\".ogv\",\".mov\",\".wmv\",\".mp4\",\".webm\",\".mp3\",\".wav\",\".mid\",\".rar\",\".zip\",\".tar\",\".gz\",\n" +
                "        \".7z\",\".bz2\",\".cab\",\".iso\",\".doc\",\".docx\",\".xls\",\".xlsx\",\".ppt\",\".pptx\",\".pdf\",\".txt\",\".md\",\".xml\"\n" +
                "    ],\n" +
                "    \"catcherUrlPrefix\":\"\",\n" +
                "    \"imageManagerListSize\":20,\n" +
                "    \"catcherFieldName\":\"source\",\n" +
                "    \"videoAllowFiles\":[\n" +
                "        \".flv\",\".swf\",\".mkv\",\".avi\",\".rm\",\".rmvb\",\".mpeg\",\".mpg\",\".ogg\",\".ogv\",\".mov\",\".wmv\",\".mp4\",\".webm\",\".mp3\",\".wav\",\".mid\"\n" +
                "    ]\n" +
                "}";
        return config;
    }

}
