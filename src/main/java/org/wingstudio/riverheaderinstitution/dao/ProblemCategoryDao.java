package org.wingstudio.riverheaderinstitution.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wingstudio.riverheaderinstitution.po.ProblemCategory;

public interface ProblemCategoryDao extends JpaRepository<ProblemCategory,Short> {
}
