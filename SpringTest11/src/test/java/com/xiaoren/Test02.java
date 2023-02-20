package com.xiaoren;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 * 动态代理
 *动态代理可以针对于一些不特定的类或者一些不特定的方法进行代理,
 * 我们可以在程序运行时动态的变化代理的规则，代理类在程序运行时才创建的代理模式成为动态代理。
 * 这种情况下，代理类并不是在Java代码中定义好的，而是在程序运行时根据我们的在Java代码中的“指示”动态生成的
 * Proxy  动态代理 JDK动态代理         面向接口
 * JDK Proxy 动态代理面向接口的动态代理  一定要有接口和实现类的存在 代理对象增强的是实现类 在实现接口的方法重写的方法
 *    生成的代理对象只能转换成 接口的不能转换成 被代理类
 *    代理对象只能增强接口中定义的方法  实现类中其他和接口无关的方法是无法增强的
 *    代理对象只能读取到接口中方法上的注解 不能读取到实现类方法上的注解
 */
public class Test02 {
    public static void main(String[] args) {
        final Dinner dinner = new Person1("正三");

        // 通过Porxy动态代理获得一个代理对象,在代理对象中,对某个方法进行增强
        /**     Proxy.newProxyInstance()
         * ClassLoader loader,
         * Class<?>[] interfaces,
         * InvocationHandler h
         */
        // ClassLoader loader,被代理的对象的类加载器
        ClassLoader loader = dinner.getClass().getClassLoader();
        //Class<?>[] interfaces,被代理对象所实现的所有接口
        Class<?>[] interfaces = dinner.getClass().getInterfaces();
        // InvocationHandler h,执行处理器对象,专门用于定义增强的规则
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //Object proxy,
                //Method method,
                //Object[] args
                //创建一个返回值null
                Object res = null;
                //如果是eat再增加新的方法
                if (method.getName().equals("eat")) {
                    System.out.println("饭前洗手");
                    // 让原有的eat的方法去运行
                    res = method.invoke(dinner, args);
                    System.out.println("饭后洗手");
                } else {
                    //如果是drink，执行原有方法
                    res = method.invoke(dinner, args);
                }
                return res;
            }
        };
        Dinner dinner1 = (Dinner) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
        // dinner1.eat("饺子");//增加新功能的方法
        dinner1.drink();
    }
}

interface Dinner {
    void eat(String foodName);

    void drink();
}

class Person1 implements Dinner {
    private String name;

    public Person1(String name) {
        this.name = name;
    }

    @Override
    public void eat(String foodName) {
        System.out.println(name + "正在吃" + foodName);
    }

    @Override
    public void drink() {
        System.out.println(name + "正在和奶茶");
    }
}

class Student implements Dinner {
    private String name;

    @Override
    public void eat(String foodName) {
        System.out.println(name + "正在吃饭" + foodName);
    }

    @Override
    public void drink() {
        System.out.println(name + "正在喝奶茶");
    }
}