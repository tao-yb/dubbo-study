package com.dubbuo.service.Anno;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.PropertySource;

@EnableDubbo(scanBasePackages = "com.dubbuo.service.Anno")
//@PropertySource("dubbo.properties")
public class DubboConfig {
}
