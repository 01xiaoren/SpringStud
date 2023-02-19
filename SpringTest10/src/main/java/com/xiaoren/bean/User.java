package com.xiaoren.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


/***
 * @Component 放在类上, 用于标记, 告诉spring当前类需要由容器实例化bean并放入容器中
 *   该注解有三个子注解
 *   @Controller 用于实例化controller层bean
 *         @Service 用于实例化service层bean
 *         @Repository 用于实例化持久层bean
 *   当不确定是哪一层,就用Component
 * 这几个注解互相混用其实也可以,但是不推荐
 */


//@Component 默认是类名的小写
//@Component("user1")//指定id
@Service
//@Controller
//@Repository
public class User {
}
