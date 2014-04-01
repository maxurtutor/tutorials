package org.maxur.ioc.service;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>3/28/2014</pre>
 */
public class Message2 {

    public void print() {
        ServiceLocator locator = ServiceLocator.get();
        HelloService service = locator.getBean(HelloService.class);
        System.out.println(service.sayHello());
    }

}
