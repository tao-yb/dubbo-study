package com.dubbo.consume;

import com.dubbo.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consume {
    public static void main(String[] args) {
        final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consume.xml");
        final UserService userService = applicationContext.getBean(UserService.class);
        System.out.println(userService.queryUser("tao"));

    }
}
