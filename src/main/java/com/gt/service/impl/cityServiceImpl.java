package com.gt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gt.Mapper.cityMapper;
import com.gt.bean.city;
import com.gt.service.cityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cityServiceImpl extends ServiceImpl<cityMapper, city> implements cityService {

    @Autowired
    cityMapper cityMapper;

    @Override
    public city getCityById(int id) {
        return cityMapper.getById(id);
    }
}
