package org.wingstudio.riverheaderinstitution.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.po.User;
import org.wingstudio.riverheaderinstitution.service.IUserService;
import org.wingstudio.riverheaderinstitution.vo.UserVo;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/list")
    public ServerResponse<List<UserVo>> list(){
        return iUserService.list();
    }

    @PostMapping("/setUserCategory")
    public ServerResponse<UserVo> setUserCategory(
            @RequestParam("userId") Long userId,
            @RequestParam("categoryId") Short userCategoryId){
        return iUserService.setUserCategory(userId,userCategoryId);
    }

}
