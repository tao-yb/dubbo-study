package com.dubbuo.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class XmlProvider {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("provider.xml");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
