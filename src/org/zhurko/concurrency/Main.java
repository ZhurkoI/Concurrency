package org.zhurko.concurrency;

public class Main {

    public static void main(String[] args) {
        Foo foo = new Foo();

        for (int i = 0; i < 1000; i++) {
            new FooThreadC(foo, "C");
            new FooThreadB(foo, "B");
            new FooThreadA(foo, "A");
            System.out.println();
        }
    }
}
