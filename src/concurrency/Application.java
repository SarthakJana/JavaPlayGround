package concurrency;

public class Application {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //myThread.start();


        RunnableThread runnableThread = new RunnableThread();

        Thread thread = new Thread(runnableThread);
//        thread.start();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();

    }
}
