package com.dubbuo.service.Anno.version;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.VersionService;

@Service(version = "2")
public class V02Service implements VersionService {
    @Override
    public String version() {
        return "v02";
    }
}
