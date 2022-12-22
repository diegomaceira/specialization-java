package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonitorController {


    @GetMapping("/executeThreads")
    public ResponseEntity executeThreads() throws InterruptedException {

        Thread thread1 = new Thread(new MonitorController.LifeCycleRunnable(),"HILO1");
        Thread thread2 = new Thread(new MonitorController.LifeCycleRunnable(),"HILO2");

        printThreadInfo(thread1);
        printThreadInfo(thread2);

        thread1.start();
        thread2.start();

        printThreadInfo(thread1);
        printThreadInfo(thread2);

        thread1.join();
        thread2.join();

        printThreadInfo(thread1);
        printThreadInfo(thread2);

        System.out.println("counter : " + counter);

        return ResponseEntity.ok("OK");
    }

    static Integer counter=0;
    public static class LifeCycleRunnable implements Runnable{

        @Override
        public void run() {
            try {

                synchronized(this){

                    for (int i = 0; i < 5; i++) {
                        counter++;
                    }
                    Thread.sleep(10000);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void printThreadInfo(Thread thread) {
        System.out.println("-----------------------");
        System.out.println("PID: " + thread.getId());
        System.out.println("Name: " + thread.getName());
        System.out.println("State: " + thread.getState());
        System.out.println("-----------------------");
    }

}
