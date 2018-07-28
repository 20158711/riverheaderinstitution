package org.wingstudio.riverheaderinstitution.service;

import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.po.User;
import org.wingstudio.riverheaderinstitution.vo.UserCategoryVo;

import java.util.List;

public interface IUserCategoryService {

    ServerResponse<List<UserCategoryVo>> listUserCategoryVos();

    ServerResponse<UserCategoryVo> findUserCategoryVoById(Short id);

    ServerResponse<UserCategoryVo> addUserCategoryVo(UserCategoryVo userCategory);

    ServerResponse<UserCategoryVo> delUserCategoryVoById(Short userCategoryId);

    ServerResponse<List<User>> listUsers(Short userCategoryId);

}
