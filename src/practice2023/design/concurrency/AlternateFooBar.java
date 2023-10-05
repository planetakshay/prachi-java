package practice2023.design.concurrency;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode.com/problems/print-foobar-alternately/description/
 */

public class AlternateFooBar {
    private final int n;
    private final Semaphore foo;
    private final Semaphore bar;
    private boolean printedFoo;

    public AlternateFooBar(int n) {
        this.n = n;
        foo = new Semaphore(0);
        bar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }

    public void fooWithWait(Runnable printFoo) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < n; i++) {
                while (printedFoo) {
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                printedFoo = true;
                notifyAll();
            }
        }
    }

    public void barWithWait(Runnable printBar) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < n; i++) {
                while (!printedFoo) {
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                printedFoo = false;
                notifyAll();
            }
        }
    }
}