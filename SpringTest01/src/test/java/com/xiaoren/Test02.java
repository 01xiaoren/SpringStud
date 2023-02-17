package com.xiaoren;

public class Test02 {
    public static void main(String[] args) {
        new son().doSon();
    }
}

class father {
    public void smoke() {
        System.out.println("抽烟");
    }
}

class mother {
    public void drink() {
        System.out.println("喝酒");
    }
}

class son {
    class inter01 extends father {
    }

    class inter02 extends mother {
    }

    public void doSon() {
        this.new inter01().smoke();
        this.new inter02().drink();
    }
}