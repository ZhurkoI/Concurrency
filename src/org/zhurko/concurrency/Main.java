package org.zhurko.concurrency;

public class Main {

    public static void main(String[] args) {
        Foo foo = new Foo();

        new FooThreadC(foo, "C");
        new FooThreadB(foo, "B");
        new FooThreadA(foo, "A");
    }
}
