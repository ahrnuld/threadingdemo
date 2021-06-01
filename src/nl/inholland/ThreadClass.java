package nl.inholland;

class ThreadClass extends Thread {
    public static void main(String[] args) {
        System.out.println("This is the main thread: " + Thread.currentThread().getName());
        ThreadClass tc = new ThreadClass();
        tc.start();
    }
    @Override
    public void run() {
        System.out.println("This thread has name: " + Thread.currentThread().getName());
    }
}
