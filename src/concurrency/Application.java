package concurrency;

public class Application {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
        MyThread myThread1 = new MyThread();
        myThread1.run();
    }
}
