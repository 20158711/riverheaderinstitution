package org.wingstudio.riverheaderinstitution.service;

import org.springframework.data.domain.Page;
import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.po.News;

import java.util.List;


public interface INewsService {

    ServerResponse<String> addNews(News news);

    ServerResponse<Page<News>> listNews(Integer pageIndex, Integer pageSize, String title);

    ServerResponse<News> getNewsById(Long newsId);

    ServerResponse<News> updateNews(News news);

    ServerResponse deleteByIds(List<Long> longList);

}
