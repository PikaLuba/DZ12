package org.example.Task2;

public class B extends Thread {
    private Resource resource;

    public B (Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int item = 1;
        while (!B.currentThread().isInterrupted()) {
            try {
                resource.buzz(item++);
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
                break;
            }
        }
    }
}

