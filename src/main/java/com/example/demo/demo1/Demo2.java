package com.example.demo.demo1;

/**
 * 判断线程状态是不是停止 java 提供了两种方法
 * 第一个方法：static this.interrupted() 测试当前线程是否已经中断
 * 第二个方法：this.isInterrupted() 测试线程是否已经中断
 */
public class Demo2 {

    public static void main(String[] args) throws Exception {

        /*//wn 测试 interrupted()方法  此时当前线程指的是 main线程*/
//        R r = new R();
//        r.start();
//        Thread.sleep(1000);
//        r.interrupt();
//        System.out.println("是否停止" + r.interrupted());
//        System.out.println("是否停止" + r.interrupted());
//        System.out.println("end");

        //结果：
//        是否停止：false
//        是否停止：false
//        end


        //wn 官方解释 线程的中断状态由该方法来清除，换句话说，如果连续两次调用该方法，
        //wn 则第二次返回 false 第一次调用已经清除了其中断状态（该线程在第一次调用之后，
        //wn 第二次调用之前再次中断的状态除外）
//        Thread.currentThread().interrupt();
//        System.out.println("是否停止：" + Thread.interrupted());
//        System.out.println("是否停止：" + Thread.interrupted());
//        System.out.println("end");

//        结果：
//        是否停止：false
//        是否停止：false
//        end

        //wn isInterrupted() 测试《当前》（注意是当前！）线程是否已经中断，但是不清除标记状态，所以显示
        //wn 都是true   虽然isInterrupted()不能打断 但是可以判断以后抛出一个 异常来catch
        //wn 这样后面的逻辑就不会再执行了
//       if(isInterrupted())
//          new InterruptedException()
//        .....后边的逻辑不再执行
        R r = new R();
        r.start();
        Thread.sleep(10);
        r.interrupt();
        System.out.println("是否停止" + r.isInterrupted());
        System.out.println("是否停止" + r.isInterrupted());
        System.out.println("end");
//        是否停止true
//        是否停止true

    }

    static class R extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
                System.out.println("i:=" + i);
            }
        }
    }
}
