package com.example.demo.demo1;

/**
 */
public class Demo3 {

    public static void main(String[] args) {

        /*//wn 测试先sleep()再interrupt()*/

        try {
            R r = new R();
            r.start();
            Thread.sleep(1000);
            r.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
        //结果
//        run begin
//        java.lang.InterruptedException: sleep interrupted
//        end
//        at java.lang.Thread.sleep(Native Method)
//        在沉睡中被停止，进入自己的catch  false
//        at com.example.demo.demo1.Demo3$R.run(Demo3.java:30)

        //结论
        //wn 在sleep状态下停止线程，会进入catch语句，并清除停止状态值

    }

    static class R extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("run begin");
                Thread.sleep(2000);
                System.out.println("run end");
            } catch (InterruptedException e) {
                System.out.println("在沉睡中被停止，进入自己的catch  " + this.isInterrupted());
                e.printStackTrace();
            }
        }
    }
}
