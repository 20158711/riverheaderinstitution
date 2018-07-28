package org.wingstudio.riverheaderinstitution.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.service.IUserCategoryService;
import org.wingstudio.riverheaderinstitution.vo.UserCategoryVo;

import java.util.List;

@RestController
@RequestMapping("/userCategory")
public class UserCategoryController {

    @Autowired
    private IUserCategoryService iUserCategoryService;

    @RequestMapping("/list")
    public ServerResponse<List<UserCategoryVo>> list(){
        return iUserCategoryService.listUserCategoryVos();
    }

    @RequestMapping("/findById/{userCategoryId}")
    public ServerResponse<UserCategoryVo> findById(@PathVariable("userCategoryId") Short id){
        ServerResponse<UserCategoryVo> userCategoryVo = iUserCategoryService.findUserCategoryVoById(id);
        return userCategoryVo;
    }

    @RequestMapping("/addUserCategory")
    public ServerResponse<UserCategoryVo> addOrUpdateUserCategory(UserCategoryVo userCategoryVo){
        return iUserCategoryService.addUserCategoryVo(userCategoryVo);
    }

    @RequestMapping("/delUserCategory")
    public ServerResponse<UserCategoryVo> delUserCategoryById(Short id){
        return iUserCategoryService.delUserCategoryVoById(id);
    }

}
