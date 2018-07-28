package org.wingstudio.riverheaderinstitution.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wingstudio.riverheaderinstitution.po.UserCategory;

public interface UserCategoryDao extends JpaRepository<UserCategory,Short> {
}
