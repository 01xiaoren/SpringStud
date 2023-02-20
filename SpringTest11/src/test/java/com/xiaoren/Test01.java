package com.xiaoren;

/**
 * 静态代理
 * 静态代理中代理类与被代理类都需要实现同一个接口，
 * 这就说明我们的一个静态代理类只能代理一个类，
 * 并且还要事先知道我们要代理哪个类才能写代理类，
 * 如果我们有其他类还想使用代理那就必须再写一个代理类。
 * 然而在实际开发中我们是可能是有非常多的类是需要被代理的，并且事先我们可能并不知道我们要代理哪个类。所以如果继续使用静态代理反而会增加许多的工作量，并且效率低下，代码复用率也不好。
 */
public class Test01 {
    public static void main(String[] args) {
        Person person = new Person("张三");
        Court court = new Lawyer(person);
        court.doCourt();
    }
}

// 接口
interface Court {
    void doCourt();
}

// 代理类
class Lawyer implements Court {
    private Person person;

    public Lawyer(Person person) {
        this.person = person;
    }

    @Override
    public void doCourt() {
        System.out.println("律师取证:视频证明张三当时正在旅游,不在案发现场");
        System.out.println("律师总结:张三不可能去杀人");
        person.doCourt();
    }
}

// 被代理的类
class Person implements Court {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void doCourt() {
        System.out.println(name + "说:我没有杀人");
    }
}