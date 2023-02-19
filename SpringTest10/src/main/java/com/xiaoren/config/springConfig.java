package com.xiaoren.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.xiaoren")//扫描bean加载的文件
//@PropertySource("classpath:  .properties ")加载properties文件
public class springConfig {
}
