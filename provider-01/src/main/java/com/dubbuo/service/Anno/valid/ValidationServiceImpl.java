package com.dubbuo.service.Anno.valid;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.User;
import com.dubbo.ValidationService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j(topic = "test")
public class ValidationServiceImpl implements ValidationService {
    @Override
    public void save(User user) {
        log.info("user:{}",user);
    }
}
