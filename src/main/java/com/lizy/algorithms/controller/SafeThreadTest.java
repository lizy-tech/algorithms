package com.lizy.algorithms.controller;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

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
//    @Override
//    public void run(){
//        try {
//            synchronized (this){
//                wait(10000);
//                increate();
//            }
//
//        } catch (Exception e) {
//            System.out.println("exception"+e);
//        }
//    }


    @Override
    public void run() {
//        synchronized (currentThread()){
            for (int j = 0; j < 5; j++) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("睡眠"+j);
            }
            System.out.println("TestJoin finished");
//        }
    }

    public static void main(String[] args)throws InterruptedException {
        Thread t = new Thread(new SafeThreadTest());
        long start = System.currentTimeMillis();
        t.start();
        t.join();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("Main finished");
//        for (int j = 0; j < 1000; j++) {
//            SafeThreadTest safeThreadTest = new SafeThreadTest();
//
//            Thread thread = new Thread(safeThreadTest);
//            thread.start();
//
//
//        }

//        lock.notifyAll();

//        try {
//            ThreadA t1 = new ThreadA("t1"); // 新建“线程t1”
//
//            t1.start();                     // 启动“线程t1”
//            t1.join(100);                        // 将“线程t1”加入到“主线程main”中，并且“主线程main()会等待它的完成”
//            System.out.printf("%s finish\n", Thread.currentThread().getName());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    static class ThreadA extends Thread{

        public ThreadA(String name){
            super(name);
        }
        public void run(){
            System.out.printf("%s start\n", this.getName());

            // 延时操作
            for(int i=0; i <1000000; i++)
                ;

            System.out.printf("%s finish\n", this.getName());
        }
    }
}
