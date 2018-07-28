package org.wingstudio.riverheaderinstitution.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wingstudio.riverheaderinstitution.BaseTest;
import org.wingstudio.riverheaderinstitution.TestUtil;
import org.wingstudio.riverheaderinstitution.po.UserCategory;

import static org.junit.Assert.*;

public class UserCategoryDaoTest extends BaseTest {

    private UserCategory category=new UserCategory();

    @Autowired
    private UserCategoryDao userCategoryDao;

    @Before
    public void setUp() throws Exception {
        category.setCategoryName("社区主任");
    }

    @Test
    public void addTest(){
        UserCategory save = userCategoryDao.save(category);
        TestUtil.print(save);
        Assert.assertNotNull(save);
    }
}