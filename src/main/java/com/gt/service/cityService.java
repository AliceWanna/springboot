package com.gt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gt.bean.city;

public interface cityService extends IService<city> {

    city getCityById(int id);
}
