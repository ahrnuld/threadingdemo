package nl.inholland;

public class Deadlock {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + ", I have lock 1");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(Thread.currentThread().getName() + ", waiting for lock 2");
                    synchronized (lock2) {
                        System.out.println(Thread.currentThread().getName() + ", holding lock 1 & 2");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + ", I have lock 2");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ie) {
                    }
                    System.out.println(Thread.currentThread().getName() + ", waiting for lock 1");
                    synchronized (lock1) {
                        System.out.println(Thread.currentThread().getName() + ", holding lock 1 & 2");
                    }
                }
            }
        }).start();
    }
}
