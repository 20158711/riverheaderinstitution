package org.wingstudio.riverheaderinstitution.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wingstudio.riverheaderinstitution.po.River;

public interface RiverDao extends JpaRepository<River,String> {
}
