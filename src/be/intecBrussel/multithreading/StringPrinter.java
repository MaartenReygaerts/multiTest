package be.intecBrussel.multithreading;

public class StringPrinter implements Runnable {

    private int count;
    private String value;

    private Object monitor;

    public StringPrinter(int count, String value) {
        super();
        this.count = count;
        this.value = value;
    }

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            synchronized (monitor) {
                monitor.notifyAll();
                System.out.println(value);

                try{
                    monitor.wait();

                    if(i == count){
                        System.exit(1);
                    }
                }catch (InterruptedException ie){
                    System.out.println(ie.getMessage());
                }
            }
        }
    }
}
