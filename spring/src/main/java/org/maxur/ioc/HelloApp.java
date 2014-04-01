package org.maxur.ioc;

import org.maxur.ioc.service.AppConfig;
import org.maxur.ioc.service.HelloService;
import org.maxur.ioc.service.Message1;
import org.maxur.ioc.service.Message2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService helloService = context.getBean(HelloService.class);
        System.out.println(helloService.sayHello());

        context.getBean(Message1.class).print();
        context.getBean(Message1.class).print();

        new Message2().print();

    }
}
