package org.wingstudio.riverheaderinstitution.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.wingstudio.riverheaderinstitution.po.News;

import javax.transaction.Transactional;
import java.util.List;

public interface NewsDao extends JpaRepository<News,Long> {
    Page<News> findNewsByNewsTitleLike(String title, Pageable pageable);
    @Transactional @Modifying
    @Query("delete from News n where n.id in (:ids)")
    int deleteByIds(@Param("ids")List<Long> list);
}
