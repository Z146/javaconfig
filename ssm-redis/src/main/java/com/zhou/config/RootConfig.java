package com.zhou.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * @author 10543
 */
@Configuration
@EnableTransactionManagement
@Import({MybatisDataSourceConfig.class,RedisCacheConfig.class})
@ComponentScan(basePackages = {"com.zhou"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value= EnableWebMvc.class)})
public class RootConfig {

}
