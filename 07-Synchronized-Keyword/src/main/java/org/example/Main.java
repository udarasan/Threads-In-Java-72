package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Calculation cal = new Calculation();
        Thread t1 = new Thread(() -> {
           for (int i = 0; i < 1000; i++) {
               cal.increment();
           }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                cal.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Value Is : "+cal.num);
    }
}
class Calculation{
    int num;
    public synchronized void increment(){
        num++;
    }
}

