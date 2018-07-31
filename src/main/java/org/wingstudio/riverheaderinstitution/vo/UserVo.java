package org.wingstudio.riverheaderinstitution.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.wingstudio.riverheaderinstitution.po.Event;
import org.wingstudio.riverheaderinstitution.po.River;
import org.wingstudio.riverheaderinstitution.po.User;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {

    public static UserVo userToVo(User user){
        UserVo userVo=new UserVo();
        userVo.setId(user.getId());
        userVo.setUsername(user.getUsername());
        userVo.setTel(user.getTel());
        userVo.setUserCategory(user.getUserCategory()==null?null:user.getUserCategory().getCategoryName());
        return userVo;
    }

    private Long id;
    private String username;
    private String tel;
    private String userCategory;
    //TODO
//    private Set<Event> events;
    //TODO
//    private Set<River> rivers;
}
