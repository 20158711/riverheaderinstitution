package org.wingstudio.riverheaderinstitution.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wingstudio.riverheaderinstitution.BaseTest;
import org.wingstudio.riverheaderinstitution.TestUtil;
import org.wingstudio.riverheaderinstitution.po.RiverFunction;

import static org.junit.Assert.*;

public class RiverFunctionDaoTest extends BaseTest {

    private RiverFunction function;

    @Autowired
    private RiverFunctionDao functionDao;

    @Before
    public void setUp() throws Exception {
        function=new RiverFunction();
        function.setFunction("景观");
    }

    @Test
    public void addTest(){
        RiverFunction save = functionDao.save(function);
        TestUtil.print(save);
        Assert.assertNotNull(save);
    }
}