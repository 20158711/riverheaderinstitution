package org.wingstudio.riverheaderinstitution.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.dao.NewsDao;
import org.wingstudio.riverheaderinstitution.po.News;
import org.wingstudio.riverheaderinstitution.service.INewsService;
import java.util.List;

@Service
public class INewsServiceImpl implements INewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public ServerResponse<String> addNews(News news) {
        News saveNews=null;
        try {
             saveNews= newsDao.save(news);
        }catch (Exception e){
            return ServerResponse.createByError();
        }
        if (saveNews != null)
            return ServerResponse.createBySuccess();
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse<Page<News>> listNews(Integer pageIndex, Integer pageSize, String title) {
        if (title==null)
            title="";
        Pageable pageable=new PageRequest(pageIndex-1,pageSize);
        Page<News> news = newsDao.findNewsByNewsTitleLike("%"+title+"%", pageable);
        return ServerResponse.createBySuccess(news);
    }

    @Override
    public ServerResponse<News> getNewsById(Long newsId) {
        News one = newsDao.findById(newsId).get();
        if (one == null) {
            return ServerResponse.createByErrorMsg("查询条件错误");
        }
        return ServerResponse.createBySuccess(one);
    }

    @Override
    public ServerResponse<News> updateNews(News news) {
        News save = newsDao.save(news);
        if (save == null) {
            return ServerResponse.createByErrorMsg("保存失败");
        }
        return ServerResponse.createBySuccess(save);
    }

    @Override
    public ServerResponse<Integer> deleteByIds(List<Long> longList) {
        int i = newsDao.deleteByIds(longList);
        if (i==0)
            return ServerResponse.createByErrorMsg("没在删除什么");
        return ServerResponse.createBySuccess(i);
    }


}
