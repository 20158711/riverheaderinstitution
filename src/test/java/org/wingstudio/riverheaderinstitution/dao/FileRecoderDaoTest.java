package org.wingstudio.riverheaderinstitution.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wingstudio.riverheaderinstitution.BaseTest;
import org.wingstudio.riverheaderinstitution.TestUtil;
import org.wingstudio.riverheaderinstitution.po.FileRecoder;

import java.util.Date;

import static org.junit.Assert.*;

public class FileRecoderDaoTest extends BaseTest {

    private FileRecoder fileRecoder;

    @Autowired
    private FileRecoderDao fileRecoderDao;

    @Before
    public void setUp(){
        fileRecoder=new FileRecoder();
        fileRecoder.setId(1l);
        fileRecoder.setUpdateTime(new Date());
        fileRecoder.setFileName("测试文件.yb");
    }

    @Test
    public void add(){
        FileRecoder save = fileRecoderDao.save(fileRecoder);
        TestUtil.print(save);
        Assert.assertNotNull(save);
    }


}