package org.wingstudio.riverheaderinstitution.dao;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wingstudio.riverheaderinstitution.BaseTest;
import org.wingstudio.riverheaderinstitution.po.User;
import org.wingstudio.riverheaderinstitution.po.UserCategory;

import javax.transaction.Transactional;

public class UserAndCategoryTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserCategoryDao userCategoryDao;

    User user = new User();
    UserCategory userCategory = new UserCategory();

    @Before
    public void init() {
        user.setId(1L);
        user.setUsername("严英");
        user.setTel("123");
        userCategory.setId(Short.valueOf("1"));
        userCategory.setCategoryName("工作人员");
    }

    @Test
    @Transactional
    public void test() {
    }

    @Test
    @Transactional
    public void testAddOrRemove() {

        User saveUser = userDao.save(user);
        Assert.assertNotNull(saveUser);

        UserCategory saveUserCategory = userCategoryDao.save(userCategory);
        Assert.assertNotNull(saveUserCategory);

    }

    @Test
    @Transactional
    public void test2() {

        User user = userDao.getOne(12l);
        System.out.println(user.getUsername());
        String tel="123456";
        user.setTel(tel);
        User save1 = userDao.save(user);
        Assert.assertEquals(tel,save1.getTel());


        UserCategory category = userCategoryDao.getOne(Short.valueOf("13"));
        System.out.println(category.getCategoryName());
        String categoryName="测试人员";
        userCategory.setCategoryName(categoryName);
        UserCategory save2 = userCategoryDao.save(userCategory);
        Assert.assertEquals(categoryName,save2.getCategoryName());

        user.setUserCategory(category);
        User save = userDao.save(user);
        User user1 = userDao.getOne(12l);
        System.out.println("##########categorys##########");
        System.out.println(user1);
        System.out.println("##########categorys##########");

        Assert.assertNotNull( save.getUserCategory());

    }

    @Test
    @Transactional
    public void test3(){

        User user=userDao.getOne(1L);
        UserCategory category=userCategoryDao.getOne(Short.valueOf("1"));
        user.setUserCategory(null);
        userDao.save(user);
        user=userDao.getOne(1L);
        System.out.println(user);
        Assert.assertNotNull(user.getUserCategory());

    }


}
