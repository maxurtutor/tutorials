package org.maxur.ioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>3/28/2014</pre>
 */
@Component
public class ServiceLocator {

    private static ServiceLocator instance;

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    public void init() {
        instance = this;
    }

    public static ServiceLocator get() {
        return instance;
    }

    public <T> T getBean(Class<T> type) {
        return context.getBean(type);
    }
}
