package be.intecBrussel.multithreading;

public class Main {
    public static void main(String[] args) {

        StringPrinter printer1 = new StringPrinter(10,"ping");
        StringPrinter printer2 = new StringPrinter(10,"pong");

        Object monitor1 = new Object();


        printer1.setMonitor(monitor1);
        printer2.setMonitor(monitor1);

        Thread t1 = new Thread(printer1,"ping");
        Thread t2 = new Thread(printer2,"pong");

        t1.start();
        t2.start();
    }
}
