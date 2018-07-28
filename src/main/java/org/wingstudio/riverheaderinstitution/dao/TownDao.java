package org.wingstudio.riverheaderinstitution.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wingstudio.riverheaderinstitution.po.Town;

public interface TownDao extends JpaRepository<Town,Integer> {
}
