package org.wingstudio.riverheaderinstitution.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.po.News;
import org.wingstudio.riverheaderinstitution.service.INewsService;
import org.wingstudio.riverheaderinstitution.vo.IdsVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService iNewsService;

    /**
     * 添加新闻
     * @param news
     * @return
     */
    @RequestMapping(value = "addNews",method = RequestMethod.POST)
    public ServerResponse<String> addNews(News news){
        return iNewsService.addNews(news);
    }

    /**
     * 获取新闻列表(可通过标题查询)
     * @return
     */
    @RequestMapping("listNews")
    public ServerResponse<Page<News>> listNews(
            @RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize,
            @RequestParam(value = "title",required = false,defaultValue = "")String title
    ){
        return iNewsService.listNews(pageIndex, pageSize, title);
    }

    /**
     * 获得单个新闻
     * @param newsId
     * @return
     */
    @RequestMapping("/{newsId}")
    public ServerResponse<News> getNewsById(@PathVariable("newsId")Long newsId){
        return iNewsService.getNewsById(newsId);
    }

    @RequestMapping("/update")
    public ServerResponse<News> updateNews(News news){
        return iNewsService.updateNews(news);
    }

    /**
     * 删除新闻
     * @param ids
     * @return
     */
    @DeleteMapping
    public ServerResponse delete(@RequestBody IdsVo ids){
        List<Number> list = ids.getIds();
        return iNewsService.deleteByIds(list.stream().map(e->e.longValue()).collect(Collectors.toList()));
    }

    @GetMapping("/test")
    public List<Long> test(){
        List<Long> longs=new ArrayList<>();
        longs.add(1L);
        return longs;
    }
}
