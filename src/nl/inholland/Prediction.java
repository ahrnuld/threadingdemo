package nl.inholland;

public class Prediction {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName() + ", j = " + j);
                }
            }).start();
            new Thread(() -> System.out.println(Thread.currentThread().getName() + ": Hello world")).start();
        }
    }
}
