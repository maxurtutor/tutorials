package org.maxur.ioc.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>3/28/2014</pre>
 */
public class Message1 {

    @Autowired
    private HelloService service;

    public void print() {
        System.out.println(service.sayHello());
    }

}
