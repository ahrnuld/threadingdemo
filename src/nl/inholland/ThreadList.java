package nl.inholland;

import java.util.*;

public class ThreadList {
  // static List<String> list = new ArrayList<>(); //Collections.synchronizedList(new ArrayList<>());
    static List<String> list = Collections.synchronizedList(new ArrayList<>());
  //static Vector<String> list = new Vector<>();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++) {
                    list.add(Integer.toString(i));
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (String s : list) {
                    list.remove(s);
                }

            }
        }).start();
        System.out.println(list);
    }
}
