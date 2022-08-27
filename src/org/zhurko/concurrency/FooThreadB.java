package org.zhurko.concurrency;

public class FooThreadB implements Runnable {
    Foo f;
    String name;

    public FooThreadB(Foo foo, String name) {
        f = foo;
        this.name = name;
        new Thread(this, this.name).start();
    }

    @Override
    public void run() {
        try {
            Foo.semSecond.acquire();
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " interrupted");
        }

        f.second();

        Foo.semThird.release();
    }
}
