package org.example.Task2;

public class A extends Thread {
    private Resource resource;

    public A (Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int item = 1;
        while (!A.currentThread().isInterrupted()) {
            try {
                resource.fizz(item++);
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                // throw new RuntimeException(e);
                break;
            }
        }
    }
}

