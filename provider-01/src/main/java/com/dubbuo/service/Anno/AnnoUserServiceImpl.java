package com.dubbuo.service.Anno;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.UserService;

@Service
public class AnnoUserServiceImpl implements UserService {
    @Override
    public String queryUser(String s) {
        return s+"OK";
    }

    @Override
    public void doKill(String s) {

    }
}
