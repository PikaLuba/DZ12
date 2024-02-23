package org.example.Task2;

public class C extends Thread {
    private Resource resource;

    public C (Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int item = 1;
        while (!C.currentThread().isInterrupted()) {
            try {
                resource.fizzbuzz(item++);
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                // throw new RuntimeException(e);
                break;
            }
        }
    }
}

