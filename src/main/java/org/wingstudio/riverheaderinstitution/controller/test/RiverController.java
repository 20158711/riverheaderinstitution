package org.wingstudio.riverheaderinstitution.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.service.IRiverService;
import org.wingstudio.riverheaderinstitution.vo.RiverVo;

import java.util.List;

@RestController
@RequestMapping("/river")
public class RiverController {

    @Autowired
    private IRiverService iRiverService;

    @RequestMapping("/list")
    public ServerResponse<List<RiverVo>> list(){
        ServerResponse<List<RiverVo>> list = iRiverService.list();
        return list;
    }

    @RequestMapping("/getOne/{id}")
    public ServerResponse<RiverVo> getOne(@PathVariable("id") String id){
        ServerResponse<RiverVo> one = iRiverService.getOne(id);
        return one;
    }

}
