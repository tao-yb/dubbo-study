package com.dubbuo.service.Anno.group;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.GroupService;
import lombok.extern.slf4j.Slf4j;

@Service(group = "g2")
@Slf4j(topic = "test")
public class Group2ServiceImpl implements GroupService {
    @Override
    public String getGroupName() {
        log.info("group2 ");
        return "wang-chen";
    }
}
