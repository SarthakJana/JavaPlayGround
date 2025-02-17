package concurrency;

public class JoinRunnable implements Runnable {

    public int sleepTime;

    public JoinRunnable() {
    }

    public JoinRunnable(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i + " " + Thread.currentThread().getName());
            try {
                if (sleepTime == 0) sleepTime = 1000;
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
