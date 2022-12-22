package com.example.thread;

import java.util.concurrent.locks.ReentrantLock;

public class CommonCounter implements Runnable{

    public static Integer counter=0;
    static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();

        printThreadInfo(Thread.currentThread());

        try {
            counter++;
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void printThreadInfo(Thread thread) {
        System.out.println("PID: " + thread.getId());
        System.out.println("Name: " + thread.getName());
        System.out.println("State: " + thread.getState());
        System.out.println("-----------------------");
    }
}
