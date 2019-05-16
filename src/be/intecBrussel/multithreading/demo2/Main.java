package be.intecBrussel.multithreading.demo2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Thread thread1 = new Thread(() -> calculate(calc,100));
        Thread thread2 = new Thread(() -> calculate(calc,100));
        Thread thread3 = new Thread(() -> calculate(calc,100));

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void calculate(Calculator calc, int number) {

        Random rand = new Random();
        for (int i = 0; i < number; i++) {
            int value = rand.nextInt(10);
            calc.setValue(value);

            int result = calc.getResult();
            System.out.println(value + " : " + result);
            if(result != (value * value)){
                System.out.println("Error");
            }

        }
    }
}
