package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
       Thread t1 = new Thread(()->{
           for (int i = 0; i < 5; i++) {
               System.out.println("A :"+
                       Thread.currentThread().getPriority());
           }
       });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("B :"+
                        Thread.currentThread().getPriority());
            }
        });
       t1.start();
       t1.setPriority(Thread.MAX_PRIORITY);
       t2.start();
       t2.setPriority(Thread.NORM_PRIORITY);
       //max - 10
        //MIN - 1
        //Normal - 5
       System.out.println("T1 :"+t1.getPriority());
       System.out.println("T2 :"+t2.getPriority());
    }

}