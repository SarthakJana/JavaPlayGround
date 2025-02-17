package concurrency;

public class SynchronizationDemo {

    public int counter;

    public synchronized void increment() {
        counter++;
    }
}

