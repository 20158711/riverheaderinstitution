package org.wingstudio.riverheaderinstitution.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wingstudio.riverheaderinstitution.BaseTest;
import org.wingstudio.riverheaderinstitution.TestUtil;
import org.wingstudio.riverheaderinstitution.po.*;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

public class RiverDaoTest extends BaseTest {

    @Autowired
    private RiverDao riverDao;

    @Autowired
    private RiverFunctionDao functionDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TownDao townDao;

    @Autowired
    private RiverTypeDao riverTypeDao;

    @Autowired
    private WaterSituationDao waterSituationDao;

    private River river;

    @Before
    public void setUp() throws Exception {
        river=new River();
        river.setId("YN1");
        river.setLongitude(103.875556);
        river.setLatitude(30.745833);
        river.setRiverName("练家院子");
        river.setPosition("八角社区");
        river.setFunction(null);
        river.setRiverNumber(1);
        river.setRiverArea(760);
        river.setRiverAvgDeep(80);
        river.setRiverCubage(608);
        river.setWaterSituation(null);
        river.setSupplyWaterFrom("四、五斗渠");
        river.setDrainageWaterTo("毛渠");
        river.setExistProblem("淤泥深，杂草多，存在安全隐患");
        river.setSamples(false);
        river.setInvestment(7600);
    }

    @Test
    public void add(){
        River save = riverDao.save(river);
        TestUtil.print(save);
        Assert.assertNotNull(save);
    }


    @Test
    @Transactional
    public void select(){
        River river=riverDao.findById("YN2").get();
        System.out.println(river);
        Assert.assertNotNull(river);
    }

    @Test
    @Transactional
    public void update(){
        River river=riverDao.findById("YN2").get();
        Town town=townDao.findById(1).get();
        RiverType type=riverTypeDao.findById(Short.valueOf("1")).get();
        RiverFunction function=functionDao.findById(Short.valueOf("1")).get();
        WaterSituation waterSituation=waterSituationDao.findById(Short.valueOf("1")).get();
        User user=userDao.findById(1L).get();
        river.setTown(town);
        river.setType(type);
        river.setFunction(function);
        river.setWaterSituation(waterSituation);
        river.setHeader(user);
        River save = riverDao.save(river);
        TestUtil.print(save);
        Assert.assertNotNull(save);
    }
}