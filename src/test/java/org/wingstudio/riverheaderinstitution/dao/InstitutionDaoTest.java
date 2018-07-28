package org.wingstudio.riverheaderinstitution.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wingstudio.riverheaderinstitution.BaseTest;
import org.wingstudio.riverheaderinstitution.TestUtil;
import org.wingstudio.riverheaderinstitution.po.Institution;

import java.util.Date;

import static org.junit.Assert.*;

public class InstitutionDaoTest extends BaseTest {

    @Autowired
    private InstitutionDao institutionDao;

    private Institution institution;

    @Before
    public void setUp(){
        institution=new Institution();
        institution.setUpdateTime(new Date());
        institution.setInstitutionTitle("这是一个测试标题");
        institution.setInstitutionFrom("严老板");
        institution.setInstitutionBody("听党指挥，能打胜仗，作风优良");
    }

    @Test
    public void addInstitution(){
        Institution save = institutionDao.save(institution);
        TestUtil.print(save);
        Assert.assertNotNull(save);
    }

    @Test
    public void update(){
        String from="习大大";
        Institution one = institutionDao.findById(22L).get();
        one.setInstitutionFrom(from);
        Institution save = institutionDao.save(one);
        Assert.assertEquals(from,save.getInstitutionFrom());
    }

}