package org.example.Task2;

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource(15);
        A fizz = new A(resource);
        B buzz = new B(resource);
        C fizzbuzz = new C(resource);
        D number = new D(resource);

        fizz.start();
        buzz.start();
        fizzbuzz.start();
        number.start();

        Thread.sleep(5000l);
        resource.print();

    }
}
