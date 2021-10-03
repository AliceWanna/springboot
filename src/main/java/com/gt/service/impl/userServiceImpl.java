package com.gt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gt.Mapper.userMapper;
import com.gt.bean.Page;
import com.gt.bean.User;
import com.gt.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl extends ServiceImpl<userMapper, User> implements userService{

    @Autowired
    private userMapper userMapper;

    @Override
    public Page<User> myPage(int pageNo, int pageSize) {
        Page<User> page = new Page<>();



        int pageTotalCount = userMapper.selectCount(null).intValue();
        int pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        if(pageNo<1){
            pageNo = 1;
        }
        if(pageNo > pageTotal){
            pageNo = pageTotal;
        }
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setPageTotal(pageTotal);
        page.setPageTotalCount(pageTotalCount);
        List<User> userList = userMapper.selectItems((pageNo - 1) * pageSize, pageSize);
        page.setItems(userList);
        return page;
    }
}
