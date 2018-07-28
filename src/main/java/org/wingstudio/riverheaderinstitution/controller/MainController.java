package org.wingstudio.riverheaderinstitution.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.po.RiverFunction;

@RestController
public class MainController {

    @RequestMapping("/hello")
    public RiverFunction hello(){
        RiverFunction function=new RiverFunction();
        function.setFunction("测试用的");
        return function;
    }

    @RequestMapping("/hello1")
    public ServerResponse<RiverFunction> hello1(){
        RiverFunction function=new RiverFunction();
        function.setFunction("测试用的");
        ServerResponse<RiverFunction> bySuccess = ServerResponse.createBySuccess(function);
        return bySuccess;
    }

}
