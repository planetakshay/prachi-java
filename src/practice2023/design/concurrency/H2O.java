package practice2023.design.concurrency;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode.com/problems/building-h2o/description/
 */
public class H2O {
    Semaphore hydrogen;
    Semaphore oxygen;
    public H2O() {
        hydrogen = new Semaphore(2);
        oxygen = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oxygen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hydrogen.acquire(2);
    }
}
