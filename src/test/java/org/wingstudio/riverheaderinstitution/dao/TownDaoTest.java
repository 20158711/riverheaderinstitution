package org.wingstudio.riverheaderinstitution.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wingstudio.riverheaderinstitution.BaseTest;
import org.wingstudio.riverheaderinstitution.TestUtil;
import org.wingstudio.riverheaderinstitution.po.Town;

import static org.junit.Assert.*;

public class TownDaoTest extends BaseTest {

    private Town town;

    @Autowired
    private TownDao townDao;

    @Before
    public void setUp() throws Exception {
        town=new Town();
        town.setTownName("天王社区4组");
    }

    @Test
    public void addTest(){
        Town save = townDao.save(town);
        TestUtil.print(save);
        Assert.assertNotNull(save);
    }
}