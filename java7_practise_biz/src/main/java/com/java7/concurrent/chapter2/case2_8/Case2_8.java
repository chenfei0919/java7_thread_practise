package com.java7.concurrent.chapter2.case2_8;

/**
 * Created by lenovo on 2016/4/14.
 */
public class Case2_8 {
    public static void main(String[] args) {
        FileMock mock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);
        Producer producer = new Producer(mock, buffer);
        Thread threadproducer =  new Thread(producer, "Producer");
        Consumer[] consumers = new Consumer[3];
        Thread threadConsumers[] = new Thread[3];
        for(int i=0; i<3; i++) {
            consumers[i] = new Consumer(buffer);
            threadConsumers[i] = new Thread(consumers[i], "Consumer" + i);
        }
        threadproducer.start();
        for(int i =0; i<3; i++) {
            threadConsumers[i].start();
        }
    }
}
