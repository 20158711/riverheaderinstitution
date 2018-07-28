package org.wingstudio.riverheaderinstitution.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wingstudio.riverheaderinstitution.BaseTest;
import org.wingstudio.riverheaderinstitution.po.Event;
import org.wingstudio.riverheaderinstitution.po.ProblemDeal;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.Assert.*;

public class ProblemDealDaoTest extends BaseTest {

    private ProblemDeal problemDeal;

    @Autowired
    private ProblemDealDao problemDealDao;

    private Long problemDealId=1L;

    @Before
    public void setUp() throws Exception {

        problemDeal=new ProblemDeal();
        problemDeal.setId(problemDealId);
        problemDeal.setPullTime(new Date());

    }

    @Test
    @Transactional
    public void pullEvent(){
        Event event=new Event();
        event.setId(1L);
        problemDeal.setEvent(event);
        ProblemDeal save = problemDealDao.save(problemDeal);
        Assert.assertNotNull(save);
    }
}