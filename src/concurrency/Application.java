package concurrency;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        //myThread.start();

        RunnableThread runnableThread = new RunnableThread();

        Thread thread = new Thread(runnableThread);
//        thread.start();

//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i <= 5; i++) {
//                System.out.println(Thread.currentThread().getName() + " " + i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        thread1.start();

//        Thread jt = new Thread(new JoinRunnable(), "Chandrayaan");
//        jt.start();
//        Thread jt2 = new Thread(new JoinRunnable(2000), "SpaceX");
//        jt.join();
//        jt2.start();
//        jt2.join();

//        System.out.println("Chandrayaan Launched");


        //Synchronization

        SynchronizationDemo aSynchronizationDemo = new SynchronizationDemo();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                aSynchronizationDemo.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                aSynchronizationDemo.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Counter: " + aSynchronizationDemo.counter);

    }
}
