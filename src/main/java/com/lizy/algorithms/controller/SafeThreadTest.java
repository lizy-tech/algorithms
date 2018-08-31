package com.lizy.algorithms.controller;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-8-29 17:55
 */
public class SafeThreadTest implements Runnable {
    private static Object lock;
    private static AtomicInteger i = new AtomicInteger(0);
    public void increate(){

        i.getAndAdd(1);
        System.out.println("i======" + i);
    }
    @Override
    public void run(){
        try {
            synchronized (this){
                wait(10000);
                increate();
            }

        } catch (Exception e) {
            System.out.println("exception"+e);
        }
    }

    public static void main(String[] args) {

        for (int j = 0; j < 1000; j++) {
            SafeThreadTest safeThreadTest = new SafeThreadTest();

            Thread thread = new Thread(safeThreadTest);
            thread.start();


        }

//        lock.notifyAll();

    }
}
