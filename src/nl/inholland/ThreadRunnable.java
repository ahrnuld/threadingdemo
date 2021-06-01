package nl.inholland;

class ThreadRunnable implements Runnable {
    public static void main(String[] args) {
        System.out.println("This is the main thread: " + Thread.currentThread().getName());
        ThreadRunnable tr = new ThreadRunnable();
        new Thread(tr).start(); // wrap it in a thread
    }

    @Override
    public void run() {
        System.out.println("This thread has name: " + Thread.currentThread().getName());
    }
}

