package homework_Multithreading;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        int inputInt = 0;

        try {
            inputInt = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println("У нас тут принято вводить только целое число - его и вводи");
        }

        //Задание №2
        //Потокобезопасный счетчик: Создайте класс счетчика, который можно увеличивать из нескольких потоков без использования синхронизации.
        // Используйте атомарные операции или классы из пакета java.util.concurrent.atomic.
        ExecutorService executorService = Executors.newFixedThreadPool(inputInt);
        for (int i = 0; i < inputInt; i++) {
            executorService.submit(MultiThreadCounter::increment);
        }
        executorService.shutdown();

        //Задание номер 4
        //Параллельное вычисление факториала: Разделите вычисление факториала числа n на несколько частей и вычислите каждую часть в отдельном потоке. Затем объедините результаты.


        TwoThreadFactorialPreCalculator oddThreadFactorialPreCalculator = new TwoThreadFactorialPreCalculator(true, inputInt);
        TwoThreadFactorialPreCalculator evenThreadFactorialPreCalculator = new TwoThreadFactorialPreCalculator(false, inputInt);
        Thread oddThread = new Thread(oddThreadFactorialPreCalculator);
        Thread evenThread = new Thread(evenThreadFactorialPreCalculator);
        oddThread.start();
        evenThread.start();
        oddThread.join();
        evenThread.join();
        BigInteger evenThreadResult = oddThreadFactorialPreCalculator.getMultiplyResult();
        BigInteger oddThreadResult = evenThreadFactorialPreCalculator.getMultiplyResult();
        System.out.println("Факториал числа " + inputInt + " равен " + evenThreadResult.multiply(oddThreadResult));

        oddThread.interrupt();
        evenThread.interrupt();


        //Задание номер 6
        // Параллельная генерация случайных чисел: Реализуйте генерацию n случайных чисел в однопоточном и многопоточном режиме, измерьте и сравните время исполнения для этих реализаций.
        int max = 1000;
        int countToGenerate = 1000000;
        int threadCount = 5;
        int countToGenerateMultithreaded = countToGenerate / threadCount;

        long startTimeSingleThread = System.currentTimeMillis();
        for (int i = 0; i < countToGenerate; i++) {
            System.out.print(ThreadLocalRandom.current().nextInt(0, max));
        }
        long endTimeSingleThread = System.currentTimeMillis();


        long startTimeMultiThread = System.currentTimeMillis();
        ExecutorService executorService2 = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executorService2.execute(() -> {
                for (int j = 0; j < countToGenerateMultithreaded; j++) {
                    System.out.print(ThreadLocalRandom.current().nextInt(0, max));
                }
            });
        }
        executorService2.shutdown();
        executorService2.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        long endTimeMultiThread = System.currentTimeMillis();

        System.out.println("Время выполнения одним потоком: " + (endTimeSingleThread - startTimeSingleThread));
        System.out.println("Время выполнения " + threadCount + " потоками: " + (endTimeMultiThread - startTimeMultiThread));

    }
}