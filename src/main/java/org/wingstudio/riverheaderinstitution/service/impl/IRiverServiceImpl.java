package org.wingstudio.riverheaderinstitution.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.wingstudio.riverheaderinstitution.common.ServerResponse;
import org.wingstudio.riverheaderinstitution.dao.*;
import org.wingstudio.riverheaderinstitution.po.River;
import org.wingstudio.riverheaderinstitution.service.IRiverService;
import org.wingstudio.riverheaderinstitution.vo.RiverVo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IRiverServiceImpl implements IRiverService {

    @Autowired
    private RiverDao riverDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserCategoryDao userCategoryDao;

    @Autowired
    private TownDao townDao;

    @Autowired
    private RiverFunctionDao riverFunctionDao;

    @Autowired
    private RiverTypeDao riverTypeDao;

    @Override
    @Transactional
    public ServerResponse<List<RiverVo>> list() {
        List<River> riverList = riverDao.findAll();
        List<RiverVo> riverVoList=new ArrayList<>();
        if (!CollectionUtils.isEmpty(riverList)){
            riverList.forEach(river -> {
                RiverVo riverVo=new RiverVo();
                BeanUtils.copyProperties(river,riverVo);
                riverVo.setType(river.getType().getRiverType());
                riverVo.setTown(river.getTown().getTownName());
                riverVo.setFunction(river.getFunction().getFunction());
                riverVo.setWaterSituation(river.getWaterSituation().getSituationDesc());
                riverVo.setHeaderName(river.getHeader().getUsername());
                riverVo.setHeaderTel(river.getHeader().getTel());
                riverVo.setHeaderUserCategory(null);
                riverVoList.add(riverVo);
            });
        }
        return ServerResponse.createBySuccess(riverVoList);
    }

    @Override
    public ServerResponse<RiverVo> getOne(String id) {
        Optional<River> optionalRiver = riverDao.findById(id);
        boolean present = optionalRiver.isPresent();
        RiverVo riverVo=new RiverVo();
        if (present){
            River river=optionalRiver.get();
            BeanUtils.copyProperties(river,riverVo);
        }
        return ServerResponse.createBySuccess(riverVo);
    }
}
