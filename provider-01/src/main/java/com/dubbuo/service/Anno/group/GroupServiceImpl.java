package com.dubbuo.service.Anno.group;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.GroupService;
import lombok.extern.slf4j.Slf4j;

@Service(group = "g1")
@Slf4j
public class GroupServiceImpl implements GroupService {
    @Override
    public String getGroupName() {
        log.info("g1");
        return "tao-group";
    }
}
