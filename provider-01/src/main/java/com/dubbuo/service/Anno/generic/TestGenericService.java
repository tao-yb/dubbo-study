package com.dubbuo.service.Anno.generic;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "test")
@Service
public class TestGenericService implements GenericService {

    private void test()   {
        log.info("test");
    }

    @Override
    public Object $invoke(String method, String[] strings, Object[] objects) throws GenericException {
        log.info("method:{}",method);
        return null;
    }
}
