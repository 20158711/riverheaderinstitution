package org.wingstudio.riverheaderinstitution.service;

import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.po.User;
import org.wingstudio.riverheaderinstitution.vo.UserVo;

import java.util.List;

public interface IUserService {

    ServerResponse<List<UserVo>> list();

    ServerResponse updateUser(User user);

    ServerResponse setUserCategory(Long userId,Short UserCategoryId);

}
