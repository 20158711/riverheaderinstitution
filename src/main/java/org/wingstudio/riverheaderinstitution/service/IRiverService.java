package org.wingstudio.riverheaderinstitution.service;

import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.vo.RiverVo;

import java.util.List;

public interface IRiverService {

    ServerResponse<List<RiverVo>> list();

    ServerResponse<RiverVo> getOne(String id);

}
