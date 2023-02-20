package com.xiaoren;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 需要注入依赖
 * lib 动态代理模式
 * 增加Spring的依赖
 * 面向父类
 */
public class Test03 {
    @Test
    public void testCglib() {
        Father father = new Father();
        // 获取一个Father的代理对象
        // 1 获得一个Enhancer对象
        Enhancer enhancer = new Enhancer();
        // 2 设置父类字节码
        enhancer.setSuperclass(father.getClass());
        // 3 获取MethodIntercepter对象 用于定义增强规则
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                /***
                 * Object o,  生成之后的代理对象 personProxy
                 * Method method,  父类中原本要执行的方法  Person>>> eat()
                 *Object[] objects, 方法在调用时传入的实参数组
                 MethodProxy methodProxy  子类中重写父类的方法 personProxy >>> eat()
                 */
                Object ong = null;
                if (method.getName().equals("eat")) {
                    System.out.println("饭前洗手");
                    //如果是eat方法增强并运行、
                    ong = methodProxy.invokeSuper(o, objects);
                    System.out.println("饭后洗碗");
                } else {
                    //否则执行原方法
                    ong = methodProxy.invokeSuper(o, objects);
                }
                return ong;
            }
        };
        // 4 设置methodInterceptor
        enhancer.setCallback(methodInterceptor);
        // 5 获得代理对象
        Father fatherProxy = (Father) enhancer.create();
        // 6 使用代理对象完成功能
        fatherProxy.eat("饺子");
    }
}

class Father {
    public void eat(String foodName) {
        System.out.println("张三正在吃:" + foodName);
    }
}