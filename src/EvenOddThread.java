;/*package whatever //do not write package name here */

import java.util.concurrent.*;


// https://ide.geeksforgeeks.org/GT9pl69sr2
/*
Print even and odd nubmer usting two thread
*/

public class EvenOddThread {
	public static void main (String[] args) {
		System.out.println("GfG!");
		Printer sp = new Printer();
    Thread odd = new Thread(new Odd(sp),"Odd");
    Thread even = new Thread(new Even(sp),"Even");
    odd.start();
    even.start();
	}
}

class Printer {
    
    Semaphore semOdd = new Semaphore(1);
    Semaphore semEven = new Semaphore(0);
    
    
    public void printOdd(int i){
       try {
            semOdd.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + i);
        semEven.release();
    }
    
    public void printEven(int i){
        try {
            semEven.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + i);
        semOdd.release();
    }
}

class Odd implements Runnable {
    Printer sp;
    
    Odd (Printer printer){
        sp = printer;
    }
    
    public void run(){
        for (int i=1; i< 10; i=i+2){
            sp.printOdd(i);
        }
    }
}

class Even implements Runnable {
    Printer sp;
    
    Even ( Printer printer){
        sp = printer;
    }
  
    public void run(){
        for (int i=2; i<=10; i=i+2){
            sp.printEven(i);
        }
    }
}
