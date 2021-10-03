package com.gt.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gt.bean.city;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface cityMapper extends BaseMapper<city> {
    city getById(int id);
}
