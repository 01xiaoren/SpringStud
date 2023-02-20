package com.xiaoren.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//完全使用注解开发
@Configuration//配置类
@ComponentScan("com.xiaoren")//扫描包
@EnableAspectJAutoProxy(proxyTargetClass = true)//切面自动代理对象生成
public class SpringConfig {
}
