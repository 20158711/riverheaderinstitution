package org.wingstudio.riverheaderinstitution.ueditor;

import com.baidu.ueditor.ActionEnter;

import javax.servlet.http.HttpServletRequest;

public class MyActionEnter extends ActionEnter {

    public MyActionEnter(HttpServletRequest request, String rootPath) {
        super(request, rootPath);
    }


}
