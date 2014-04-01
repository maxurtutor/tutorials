package org.maxur.ioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>3/27/2014</pre>
 */
@Configuration
@ComponentScan(
        basePackages = {"org.maxur.ioc.service"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
)
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Message1 message() {
        return new Message1();
    }


    @Configuration
    @Profile("dev")
    static class Dev {
        @Bean
        public Integer intParam() {
            return 1;
        }
    }

    @Configuration
    @Profile("prod")
    static class Prod {

        @Autowired
        private Environment environment;

        @Bean
        public Integer intParam() {
            final String property = environment.getProperty("params.init");
            if (!property.isEmpty()) {
                return Integer.parseInt(property);
            } else {
                return 1;
            }
        }


    }


}
