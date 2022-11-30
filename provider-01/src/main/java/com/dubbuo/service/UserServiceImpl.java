package com.dubbuo.service;

import com.dubbo.UserService;


public class UserServiceImpl implements UserService {
    @Override
    public String queryUser(String s) {
        return s+"OK";
    }

    @Override
    public void doKill(String s) {

    }
}
