package com.dubbuo.service.Anno.version;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.VersionService;

@Service(version = "1")
public class V01Service implements VersionService {
    @Override
    public String version() {
        return "v01";
    }
}
