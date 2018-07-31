package org.wingstudio.riverheaderinstitution.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.wingstudio.riverheaderinstitution.BaseTest;
import org.wingstudio.riverheaderinstitution.TestUtil;
import org.wingstudio.riverheaderinstitution.po.News;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

public class NewsDaoTest extends BaseTest {

    private News news;

    @Autowired
    private NewsDao newsDao;

    @Test
    public void list(){
        Pageable pageable=new PageRequest(0,10);
        Page<News> newsByNewsTitleLike = newsDao.findNewsByNewsTitleLike("%%", pageable);
        System.out.println(newsByNewsTitleLike.getTotalElements());
    }

    @Before
    public void setUp() throws Exception {

        news=new News();
        news.setId(1L);
        news.setNewsTitle("这是一个测试新闻");
        news.setNewsAuthor("严兵");
        news.setNewsBody("今天在这里发生了一件令我很开心的事情");

    }

    @Test
    public void add(){
        News save = newsDao.save(news);
        TestUtil.print(save);
        Assert.assertNotNull(save);
    }

    @Test
    @Transactional
    public void update(){
        news.setId(24L);
        news.setNewsFrom("雅安");
        News save = newsDao.save(news);
        TestUtil.print(save);
        Assert.assertEquals("雅安",save.getNewsFrom());
    }
}