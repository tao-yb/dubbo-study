package com.dubbo.consume.anno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnoConsumer {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(DubboConfig.class);

    }
}

