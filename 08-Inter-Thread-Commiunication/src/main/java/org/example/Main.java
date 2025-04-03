package org.example;

class A{
    int num;
    public synchronized void put(int num){
        System.out.println("PUT : "+num);
        this.num = num;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void get(){
        System.out.println("GET :"+num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Producer implements Runnable{
    A a;
    public Producer(A a){
        this.a=a;
        Thread t1 = new Thread(this,"Producer");
        t1.start();
    }
    @Override
    public void run() {
        int num = 0;
        while(true){
            a.put(num++);
        }
    }
}
class Consumer implements Runnable{

    A a;
    public Consumer(A a){
        this.a=a;
        Thread t1 = new Thread(this,"Consumer");
        t1.start();
    }
    @Override
    public void run() {
        a.get();
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        A a = new A();
        new Producer(a);
        new Consumer(a);
    }
}