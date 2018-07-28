package org.wingstudio.riverheaderinstitution.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wingstudio.riverheaderinstitution.po.Institution;

public interface InstitutionDao extends JpaRepository<Institution,Long> {
}
