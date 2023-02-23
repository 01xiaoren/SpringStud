package com.xiaoren.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration//配置类标志注解
@ComponentScan(basePackages = "com.xiaoren")//包扫描
@PropertySource("jdbc.properties")//读取属性配置文件
@EnableTransactionManagement//开启事务注解
@Import({JdbcConfig.class})//扫描注解类
public class SpringConfig {
}
