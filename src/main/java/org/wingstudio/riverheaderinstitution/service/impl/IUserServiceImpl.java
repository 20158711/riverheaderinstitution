package org.wingstudio.riverheaderinstitution.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.dao.UserCategoryDao;
import org.wingstudio.riverheaderinstitution.dao.UserDao;
import org.wingstudio.riverheaderinstitution.po.User;
import org.wingstudio.riverheaderinstitution.po.UserCategory;
import org.wingstudio.riverheaderinstitution.service.IUserService;
import org.wingstudio.riverheaderinstitution.vo.UserVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserCategoryDao userCategoryDao;

    @Override
    public ServerResponse<List<UserVo>> list() {
        List<User> users = userDao.findAll();
        List<UserVo> userVos=new ArrayList<>();
        if (!CollectionUtils.isEmpty(users))
            userVos=users.stream().map(e-> UserVo.userToVo(e)).collect(Collectors.toList());
        return ServerResponse.createBySuccess(userVos);
    }

    @Override
    public ServerResponse updateUser(User user) {
        User save = userDao.save(user);
        if (save == null) {
            return ServerResponse.createByError();
        }
        return ServerResponse.createBySuccess(save);
    }

    @Override
    public ServerResponse<UserVo> setUserCategory(Long userId, Short userCategoryId) {
        User user = userDao.getOne(userId);
        UserCategory userCategory=userCategoryDao.getOne(userCategoryId);
        if (user==null || userCategory==null)
            return ServerResponse.createByErrorMsg("用户或用户类型为空");
        user.setUserCategory(userCategory);
        User save = userDao.save(user);
        if (save != null) {
            return ServerResponse.createBySuccess(UserVo.userToVo(user));
        }
        return ServerResponse.createByErrorMsg("修改失败");
    }
}
