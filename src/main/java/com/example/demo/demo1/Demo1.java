package com.example.demo.demo1;

/**
 * Created by laowuOvO on 2019/7/24.
 */
public class Demo1 {

    public static void main(String[] args) throws Exception{
        /*测试 currentThread() 返回那个线程正在被调用*/
        System.out.println(Thread.currentThread().getName());

        /*isAlive() 测试线程是否处于活动状态
        活动状态就是线程已经启动尚未终止，正在运行 或者准备开始运行*/
//        R r = new R();
//        System.out.println(r.isAlive());
//        r.start();
//        // wn 如果主线程睡一会 那么子线程最后打印的就不是true了 因为子线程已经执行完了
//        //Thread.sleep(1000);
//        System.out.println(r.isAlive());



    }

    static class R extends Thread{
        @Override
        public void run() {
            System.out.println("run:"+this.isAlive());
        }
    }
}
