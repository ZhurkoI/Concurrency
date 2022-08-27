package org.zhurko.concurrency;

import java.util.concurrent.Semaphore;

public class Foo {

    static Semaphore semFirst = new Semaphore(1);
    static Semaphore semSecond = new Semaphore(0);
    static Semaphore semThird = new Semaphore(0);

    public void first() {
        System.out.print("first");
    }

    public void second() {
        System.out.print("second");
    }

    public void third() {
        System.out.print("third");
    }
}
