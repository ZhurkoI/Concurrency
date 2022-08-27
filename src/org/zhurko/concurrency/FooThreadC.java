package org.zhurko.concurrency;

public class FooThreadC implements Runnable {

    Foo f;
    String name;

    public FooThreadC(Foo foo, String name) {
        f = foo;
        this.name = name;
        new Thread(this, this.name).start();
    }

    @Override
    public void run() {
        try {
            Foo.semThird.acquire();
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " interrupted");
        }

        f.third();

        Foo.semFirst.release();
    }
}
