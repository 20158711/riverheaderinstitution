package org.wingstudio.riverheaderinstitution.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wingstudio.riverheaderinstitution.po.WaterSituation;

public interface WaterSituationDao  extends JpaRepository<WaterSituation,Short> {
}
