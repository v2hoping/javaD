package com.owl.zookeeper.use.join;

/**
 * Created by wanghouping on 2018/5/10.
 *
 * @author houping wang
 */
public class JoinD {
    public static class Thread2 extends Thread {
        private Thread1 a;

        public Thread2(Thread1 a) {
            this.a = a;
        }

        @Override
        public void run() {
            synchronized (a) {
                System.out.println("B begin " + System.currentTimeMillis());
                try {
                    a.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B end " + System.currentTimeMillis());
            }
        }
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (this) {
                System.out.println("A begin " + System.currentTimeMillis());
                System.out.println("A end " + System.currentTimeMillis());
            }
        }
    }

    public static void main(String[] args) {
        JoinD.Thread1 thread = new JoinD.Thread1();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JoinD.Thread2 thread2 = new JoinD.Thread2(thread);
        thread2.start();
        thread.start();
        System.out.println("main end " + System.currentTimeMillis());
        try {
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
