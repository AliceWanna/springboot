package com.gt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gt.bean.Page;
import com.gt.bean.User;

public interface userService extends IService<User> {


    Page<User> myPage(int pageNo, int pageSize);
}
