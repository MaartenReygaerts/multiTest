package be.intecBrussel.multithreading.demo2;

public class Calculator {
    private int value = 0;
    private int result = 0;
    private boolean done = true;
    private boolean busy = false;
    private Thread t;

    public Calculator(){
        Thread thread = new Thread(() -> calculate());
        thread.setDaemon(true);
        thread.start();
    }

    public synchronized void setValue(int value){
        while(busy){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        this.value = value;
        done=false;
        busy=true;
        notifyAll();
    }

    public synchronized int getResult(){
        while(!done){ //Wachten tot de berekening gedaan is
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        busy = false;
        notifyAll();
        return result;
    }


    private synchronized void calculate() {
        while(true){ //oneindige lus
            while(done){ //wacht tot er iets te berekenen is
                try{
                    wait();
                }catch (InterruptedException e){

                }
            }
            result = value * value; //bereken het resultaat
            done = true;
            notifyAll();
        }
    }

}
