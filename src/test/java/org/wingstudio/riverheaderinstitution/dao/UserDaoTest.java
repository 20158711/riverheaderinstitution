package org.wingstudio.riverheaderinstitution.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wingstudio.riverheaderinstitution.BaseTest;
import org.wingstudio.riverheaderinstitution.TestUtil;
import org.wingstudio.riverheaderinstitution.po.User;
import org.wingstudio.riverheaderinstitution.po.UserCategory;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest extends BaseTest {

    private User user=new User();

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserCategoryDao categoryDao;

    @Before
    public void setUp() throws Exception {
        user.setUsername("刘沙");
        user.setTel("18608042283");
    }

    @Test
    @Transactional
    public void addUser(){
        List<User> all = userDao.findAll();
        UserCategory category = categoryDao.findById(Short.valueOf("1")).get();
        all.forEach(e->{
            e.addUserCategory(category);
        });
        List<User> users = userDao.saveAll(all);
        System.out.println(users.size());
        Assert.assertNotEquals(0,users.size());
    }
}