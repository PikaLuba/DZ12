package org.example.Task2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Resource {
    private Queue<Integer> sharedResource = new LinkedList<>();
    private  static String[] str = new String[15];
    private int capacity;

    public Resource(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void fizz(int item) throws InterruptedException {
        if (item % 3 == 0 && item % 5 != 0) {
            while (sharedResource.size() == capacity) {
                wait();
            }
            sharedResource.add(item);
            str[item-1] = "fizz";
            //  System.out.println("fizz");
            notify();
        }

    }

    public synchronized void buzz(int item) throws InterruptedException {
        if (item % 5 == 0 && item % 3 != 0) {
            while (sharedResource.size() == capacity) {
                wait();
            }
            sharedResource.add(item);
            str[item-1] = "buzz";
            //  System.out.println("buzz");
            notify();
        }
    }

    public synchronized void fizzbuzz(int item) throws InterruptedException {
        if (item % 15 == 0) {
            while (sharedResource.size() == capacity) {
                wait();
            }
            sharedResource.add(item);
            str[item-1] = "fizzbuzz";
            //   System.out.println("fizzbuzz");
            notify();
        }
    }

    public synchronized void number(int item) throws InterruptedException {
        if ((item % 15 == 0) || (item % 3 == 0) || (item % 5 == 0))  {
            //
        } else {
            while (sharedResource.size() == capacity) {
                 wait();
            }
            sharedResource.add(item);
            str[item-1] = String.valueOf(item);
            //   System.out.println(item);
               notify();
        }
    }

    public void print() {
        System.out.println(Arrays.toString(str));
    }
}
