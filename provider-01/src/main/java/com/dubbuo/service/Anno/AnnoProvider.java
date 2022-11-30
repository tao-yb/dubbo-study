package com.dubbuo.service.Anno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class AnnoProvider {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(DubboConfig.class);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
