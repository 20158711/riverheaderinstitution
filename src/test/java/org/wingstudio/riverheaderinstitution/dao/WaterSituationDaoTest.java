package org.wingstudio.riverheaderinstitution.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wingstudio.riverheaderinstitution.BaseTest;
import org.wingstudio.riverheaderinstitution.TestUtil;
import org.wingstudio.riverheaderinstitution.po.WaterSituation;

import static org.junit.Assert.*;

public class WaterSituationDaoTest extends BaseTest {

    @Autowired
    private WaterSituationDao waterSituationDao;

    private WaterSituation waterSituation;

    @Before
    public void setUp(){
        waterSituation=new WaterSituation();
    }

    @Test
    public void addTest() throws Exception {

//        waterSituation.setSituationDesc("较好");
//        WaterSituation save1 = waterSituationDao.save(waterSituation);
//        TestUtil.print(save1);
//        Assert.assertNotNull(save1);

//        waterSituation.setSituationDesc("一般");
//        WaterSituation save2 = waterSituationDao.save(waterSituation);
//        TestUtil.print(save2);
//        Assert.assertNotNull(save2);

        waterSituation.setSituationDesc("较差");
        WaterSituation save3 = waterSituationDao.save(waterSituation);
        TestUtil.print(save3);
        Assert.assertNotNull(save3);

    }
}