package com.java7.concurrent.chapter1.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/7.
 */
public class UnsafeTask implements Runnable {
    private Date startDate;
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread: %s: %s\n", Thread.currentThread().getId(), startDate);
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Ending Thread: %s: %s\n", Thread.currentThread().getId(), startDate);
    }
}
