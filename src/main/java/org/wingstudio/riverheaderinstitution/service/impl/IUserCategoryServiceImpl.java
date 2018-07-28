package org.wingstudio.riverheaderinstitution.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.dao.UserCategoryDao;
import org.wingstudio.riverheaderinstitution.po.User;
import org.wingstudio.riverheaderinstitution.po.UserCategory;
import org.wingstudio.riverheaderinstitution.service.IUserCategoryService;
import org.wingstudio.riverheaderinstitution.vo.UserCategoryVo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IUserCategoryServiceImpl implements IUserCategoryService {

    @Autowired
    private UserCategoryDao userCategoryDao;


    @Override
    public ServerResponse<List<UserCategoryVo>> listUserCategoryVos() {
        List<UserCategory> all = userCategoryDao.findAll();
        List<UserCategoryVo> userCategoryVos=new ArrayList<>();
        if(!CollectionUtils.isEmpty(all))
            all.forEach(userCategory->
                    userCategoryVos.add(
                            new UserCategoryVo(userCategory.getId(),userCategory.getCategoryName())));
        return ServerResponse.createBySuccess(userCategoryVos);
    }

    @Override
    public ServerResponse<UserCategoryVo> findUserCategoryVoById(Short id) {
        Optional<UserCategory> userCategory = userCategoryDao.findById(id);
        UserCategoryVo userCategoryVo=null;
        if (userCategory.isPresent()){
            userCategoryVo=new UserCategoryVo(
                 userCategory.get().getId(),
                 userCategory.get().getCategoryName()
            );
        }
        return ServerResponse.createBySuccess(userCategoryVo);
    }

    @Override
    public ServerResponse<UserCategoryVo> addUserCategoryVo(UserCategoryVo userCategoryVo) {
        UserCategory userCategory=new UserCategory();
        userCategory.setId(userCategoryVo.getId());
        userCategory.setCategoryName(userCategoryVo.getDesc());
        try {
            UserCategory save = userCategoryDao.save(userCategory);
            if (save != null) {
                return ServerResponse.createBySuccess();
            }
        }catch (Exception e){
            return ServerResponse.createByErrorMsg(e.getMessage());
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse<UserCategoryVo> delUserCategoryVoById(Short userCategoryId) {
        try {
            userCategoryDao.deleteById(userCategoryId);
        }catch (Exception e){
            return ServerResponse.createByError();
        }
        return ServerResponse.createBySuccess();
    }

    @Override
    @Transactional
    public ServerResponse<List<User>> listUsers(Short userCategoryId) {
        List<User> users=null;
        Optional<UserCategory> userCategoryOptional = userCategoryDao.findById(userCategoryId);
        if (userCategoryOptional.isPresent()){
            users=userCategoryOptional.get().getUsers().stream().collect(Collectors.toList());
        }
        return ServerResponse.createBySuccess(users);
    }
}
