package org.wingstudio.riverheaderinstitution.dao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wingstudio.riverheaderinstitution.BaseTest;
import org.wingstudio.riverheaderinstitution.TestUtil;
import org.wingstudio.riverheaderinstitution.po.RiverType;

import static org.junit.Assert.*;

public class RiverTypeDaoTest extends BaseTest {

    @Autowired
    private RiverTypeDao typeDao;

    private RiverType riverType;

    @Before
    public void setUp(){
        riverType=new RiverType();
        riverType.setRiverType("塘");
    }

    @Test
    public void addTest(){
        RiverType save = typeDao.save(riverType);
        TestUtil.print(save);
        Assert.assertNotNull(save);
    }

}