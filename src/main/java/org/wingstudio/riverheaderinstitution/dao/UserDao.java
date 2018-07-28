package org.wingstudio.riverheaderinstitution.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wingstudio.riverheaderinstitution.po.User;

public interface UserDao extends JpaRepository<User,Long> {
}
