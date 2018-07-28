package org.wingstudio.riverheaderinstitution.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wingstudio.riverheaderinstitution.po.FileRecoder;

public interface FileRecoderDao extends JpaRepository<FileRecoder,Long> {
}
