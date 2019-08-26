package com.zhou.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@PropertySource("classpath:jdbc.properties")
@MapperScan(basePackages = "com.zhou.mappers")
public class MybatisDataSourceConfig {
    private static final Logger logger=Logger.getLogger(MybatisDataSourceConfig.class);

    //通过读取配置文件的将值赋予定义的字段
    @Value("${druid.driver}")
    private String driver;
    @Value("${druid.url}")
    private String url;
    @Value("${druid.username}")
    private String username;
    @Value("${druid.password}")
    private String password;

    /*
    配置 Druid 连接池
     */
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        logger.info(driver);
        logger.info(url);
        logger.info(username);
        logger.info(password);

        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        logger.info("使用 DataSource 的事务控制");
        return new DataSourceTransactionManager(dataSource());
    }

    /*
    配置 JdbcTemplate 模板
     */
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
    /*
    配置 NamedParameterJdbcTemplate 模板,可以使用参数命名来赋值
     */
    //@Bean
    //public NamedParameterJdbcTemplate jdbcTemplate(){
    //    return new NamedParameterJdbcTemplate(dataSource());
    //}


    /*
    整合mybatis
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        //别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.zhou.domain");
        sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath:com/zhou/mappers/*.xml"));
        //org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration();
        //sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean;
    }

}
