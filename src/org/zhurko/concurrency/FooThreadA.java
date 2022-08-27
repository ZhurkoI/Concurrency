package org.zhurko.concurrency;

import java.util.concurrent.Semaphore;

public class FooThreadA implements Runnable {
    Foo f;
    String name;

    public FooThreadA(Foo foo, String name) {
        f = foo;
        this.name = name;
        new Thread(this, this.name).start();
    }

    @Override
    public void run() {
        try {
            Foo.semFirst.acquire();
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " interrupted");
        }

        f.first();

        Foo.semSecond.release();
    }
}
