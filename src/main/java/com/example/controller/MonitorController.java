package com.example.controller;

import com.example.thread.CommonCounter;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.locks.ReentrantLock;

@RestController
public class MonitorController {


    @GetMapping("/executeThreads")
    public ResponseEntity executeThreads() throws InterruptedException {

        CommonCounter commonCounter = new CommonCounter();

        Thread thread1 = new Thread(commonCounter,"HILO1");
        Thread thread2 = new Thread(commonCounter,"HILO2");

        CommonCounter.printThreadInfo(thread1);
        CommonCounter.printThreadInfo(thread2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        CommonCounter.printThreadInfo(thread1);
        CommonCounter.printThreadInfo(thread2);

        System.out.println("counter : " + CommonCounter.counter);

        return ResponseEntity.ok("OK");
    }

/*
    public static class LifeCycleRunnable implements Runnable{
        static Integer counter=0;
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
    }

    public static void printThreadInfo(Thread thread) {
        System.out.println("PID: " + thread.getId());
        System.out.println("Name: " + thread.getName());
        System.out.println("State: " + thread.getState());
        System.out.println("-----------------------");
    }
*/
}
