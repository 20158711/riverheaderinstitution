package org.wingstudio.riverheaderinstitution.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wingstudio.riverheaderinstitution.BaseTest;
import org.wingstudio.riverheaderinstitution.po.Event;
import org.wingstudio.riverheaderinstitution.po.ProblemCategory;
import org.wingstudio.riverheaderinstitution.po.User;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.Assert.*;

public class EventDaoTest extends BaseTest {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private ProblemCategoryDao problemCategoryDao;

    @Autowired
    private UserDao userDao;

    Event event = new Event();
    ProblemCategory problemCategory = new ProblemCategory();

    @Before
    public void setUp() throws Exception {

        event.setId(2L);
        event.setProblemDesc("问题描述二");
        event.setUploadTime(new Date());

        problemCategory.setId(Short.valueOf("1"));
        problemCategory.setProblemCategory("常规问题二");

    }

    @Test
    @Transactional
    public void create() {
        Event save = eventDao.save(event);
        System.out.println(event);
        Assert.assertNotNull(save);

        ProblemCategory problemCategory = problemCategoryDao.save(this.problemCategory);
        System.out.println(problemCategory);
        Assert.assertNotNull(problemCategory);

        User user =userDao.getOne(1L);
        event.setUploadUser(user);
        event.setProblemCategory(problemCategory);

        Event saveEvent = eventDao.save(event);
        System.out.println(saveEvent);
        Assert.assertNotNull(saveEvent);

        event.setUploadUser(null);
        event.setProblemCategory(null);
        Event save1 = eventDao.save(event);
        System.out.println(save1);
        Assert.assertNotNull(save1);

    }
}