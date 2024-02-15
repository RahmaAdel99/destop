package Reviewing;



public class NewThread extends Thread implements Runnable{
    Thread t1, t2;

    NewThread() {
        t1 = new Thread(this, "Thread 1");
        t2 = new Thread(this, "Thread 2");
        t1.start();
        t2.start();
    }

    public void run() {
        t2.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t2.equals(t1));
    }
}
class multithreaded {
    public static void main(String[] args) {
        new NewThread() ;
    }
}