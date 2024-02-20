package MultiThreading;
// MultiThreading 1: Using Thread class
/**
*  Create a class extending the Thread class and override the run() method in it
*  Create an object of the created class
*  To create a new thread, call start() method on the created object
*  This creates a new thread and executes the run() method of the object
*  
*  The main method should be the last executing thread.
*  The main method should wait for all the threads to execute before exiting.
*  To achieve this, call join() method on the created threads.
*/

public class MultiThreading1 {
    public static void main(String[] args) {
        MyObject1 ob1 = new MyObject1();
        MyObject2 ob2 = new MyObject2();
        ob1.start();
        ob2.start();
        
        // Wait for threads
        try {
            ob1.join();
            ob2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Exiting Main Thread");
    }
}

class MyObject1 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Hello " + i);
                Thread.sleep(500);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting MyObject1 Thread");
    }
}

class MyObject2 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Hi " + i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting MyObject2 Thread");
    }
}
