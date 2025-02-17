package concurrency.threadlocal;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserDetailsService {

    ThreadLocal<SimpleDateFormat> dateFormatter = ThreadLocal.withInitial(() -> {
        System.out.println("sdf called");
        return new SimpleDateFormat("dd-MM-yyyy");
    });
//    ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<SimpleDateFormat>() {
//    @Override
//    protected SimpleDateFormat initialValue() {
//        System.out.println("sfd called");
//        return new SimpleDateFormat("dd-MM-yyyy");
//    }
//
//    @Override
//    public SimpleDateFormat get() {
//        return super.get();
//    }
//};

    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <= 1000; i++) {
            int id = i;
            executorService.submit(() -> {
                var bd = new UserDetailsService().birthdate(String.valueOf(id));
                System.out.println(id + " " + bd);
            });
        }
    }

    public String birthdate(String userId) {
        Date date = Date.from(Instant.now());
        var df = dateFormatter.get();
        return df.format(date);
    }
}
