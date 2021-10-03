package com.gt.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gt.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface userMapper extends BaseMapper<User> {
    @Select("select * from user limit #{begin},#{pageSize}")
    List<User> selectItems(int begin, int pageSize);
}
