package org.example;

public class MyRunnable implements Runnable {
    private String threadName;
    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }
    @Override
    public void run() {
        System.out.println("Thread Started :"+threadName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread Finished :"+threadName);
    }
}
