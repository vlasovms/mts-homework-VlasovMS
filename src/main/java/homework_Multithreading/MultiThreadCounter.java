package homework_Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadCounter {      // Задание №2
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void increment() {
        counter.incrementAndGet();
    }

    public static int get(){
        return counter.get();
    }




}
