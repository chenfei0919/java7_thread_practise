package com.java7.concurrent.chapter2.case2_7;

/**
 * Created by lenovo on 2016/4/14.
 */
public class Case2_7 {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for(int i=0; i<10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread" + i);
        }
        for(int i=0; i<10; i++) {
            thread[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {


            }
        }
    }
}
