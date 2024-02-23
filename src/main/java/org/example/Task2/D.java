package org.example.Task2;

public class D extends Thread {
    private Resource resource;

    public D (Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int item = 1;
        while (!D.currentThread().isInterrupted()) {
            try {
                resource.number(item++);
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                // throw new RuntimeException(e);
                break;
            }
        }
    }
}

