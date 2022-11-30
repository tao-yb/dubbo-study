package com.dubbo.consume.anno;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.UserService;

public class UserProxy {

    @Reference
    private UserService userService;
}
