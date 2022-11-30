package com.dubbuo.service.Anno;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.AsyncService;
import com.dubbo.User;

@Service
public class AsyncUserService implements AsyncService {
    @Override
    public User query(String id) throws InterruptedException {
        Thread.sleep(2000);
        User user = new User();
        user.setName("test");
        return user;
    }

    @Override
    public User querySync(String id) throws InterruptedException {
        Thread.sleep(2000);
        User user = new User();
        user.setName("sync");
        return user;
    }
}
