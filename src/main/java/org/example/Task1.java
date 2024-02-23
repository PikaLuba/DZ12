package org.example;

public class Task1 extends Thread {

    public static void main(String[] args) throws InterruptedException {

        int n1 = 0;

        Task1 thread_0 = new Task1();
        thread_0.start();

        Task1 thread_1 = new Task1();
        thread_1.start();

        Thread.sleep(15000l);
        thread_0.interrupt();
        thread_1.interrupt();

    }

    public void run() {
        long start = System.currentTimeMillis();
        long duration;
        String name;

        Thread current = Thread.currentThread();
        name = current.getName();

        while (!current.isInterrupted())
        {
            try {
                if (name.equals("Thread-0")) {
                    Thread.sleep(1000l);
                    duration = (System.currentTimeMillis() - start) / 1000l;
                    System.out.println("Від старту " + current.getName() + " минуло " + duration + "сек");
                } else {
                    Thread.sleep(5000l);
                    System.out.println("минуло 5 секунд");
                }
            } catch (InterruptedException e) {
                if (name.equals("Thread-0")) {
                    System.out.println("Работа потока была прервана");
                }
                break;
            }

        }
    }
}
