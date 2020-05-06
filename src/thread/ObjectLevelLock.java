package thread;


/*
Synchronize create object level lock. It is intrinic lock.
synchronize is object level lock. It is intrinisic lock.
if two synchronize methods are in same class say m1 and m2 and if two thread are trying to access m1 and m2 repectively.
They can't access simultenoulsy becasue of object level lock.
 */
public class ObjectLevelLock {

    public static void main(String[] args){


        // random order because of diffirent Display object.
        Thread t1 = new SampleThread(new Display(), "##########");
        Thread t2 = new SampleThread(new Display(), "**************");

        Display d1 = new Display();
        // fix order
        t1 = new SampleThread(d1, "#############");
        t2 = new SampleThread(d1, "**************");
        //Thread t3 = new SampleThread2(d1, "$$$$$");

        t1.start();
        t2.start();
        //t3.start();

    }
}

class SampleThread extends Thread {

    Display display;
    String msg;

    public SampleThread(Display display, String msg) {
        this.display = display;
        this.msg = msg;
    }

    @Override
    public void run() {
        display.wish(msg);
    }
}

class SampleThread2 extends Thread {

    Display display;
    String msg;

    public SampleThread2(Display display, String msg) {
        this.display = display;
        this.msg = msg;
    }

    @Override
    public void run() {
        display.wishEvening(msg);
    }
}
class Display {

    /**
     * public  synchronized void  wish(String str){ do something }
     * public  void  wish(String str){
     *  synchronized(this) {
     *  do something
     *   }
     *  }
     * Both are same and object level lock.
     */


    /**
     * public  static synchronized void  wish(String str){ do something }
     * public  void  wish(String str){
     *  synchronized(Display.class) {
     *  do something
     *   }
     *  }
     * Both are same and class level lock.
     */

    public  synchronized void  wish(String str){
        for (int i=0; i < 10; i++) {
            try {
                System.out.println(str);
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println("Exception in sleep");
            }
        }
    }

    public  void  wish2(String str){
        synchronized (this) {
            for (int i=0; i < 10; i++) {
                try {
                    System.out.println(str);
                    Thread.sleep(500);
                }catch (Exception e){
                    System.out.println("Exception in sleep");
                }
            }
        }
    }

    //class level
    public static synchronized void wishEvening(String str){
        for (int i=0; i< 10; i++) {
            try {
                System.out.println("Good Evening "+str);
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Exception in sleep");
            }
        }
    }

    public void wishEvening2(String str){
        synchronized(Display.class) {
            for (int i=0; i< 10; i++) {
                try {
                    System.out.println("Good Evening "+str);
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println("Exception in sleep");
                }
            }
        }
    }
}