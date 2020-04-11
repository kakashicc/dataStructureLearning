import com.sun.org.apache.bcel.internal.generic.NEW;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/3 10:51.
 */
public class Test {

   /* public  ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
            1L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            String name = "ThreadPool_" + UUID.randomUUID();
            Thread t = new Thread(r);
            t.setName(name);
            return t;
        }
    });*/

    {
        //threadPoolExecutor.allowCoreThreadTimeOut(false);
    }

    public static void test(){

        //Test test = new Test();
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        ThreadFactory tf = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                String name = "ThreadPool_" + UUID.randomUUID();
                Thread t = new Thread(r);
                t.setName(name);
                return t;
            }
        };
        /*ExecutorService executorService = new ThreadPoolExecutor(1, 2,
                2L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),tf);*/

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(), tf);
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                        System.out.println(Thread.currentThread().getName());
                    }
            );
            if(i==4){
                try {
                    System.out.println("睡眠15s");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //test();
        AtomicInteger poolNumber = new AtomicInteger(Integer.MAX_VALUE-1);
        System.out.println(poolNumber.getAndIncrement());
        System.out.println(poolNumber.getAndIncrement());
        System.out.println(poolNumber.getAndIncrement());
        System.out.println(poolNumber.getAndIncrement());
        System.out.println(poolNumber.getAndIncrement());

       /* while(true){
            System.out.println(poolNumber.getAndIncrement());

        }*/
        //System.out.println("执行完毕");

        //test.threadPoolExecutor.shutdown();

        //test.threadPoolExecutor.allowCoreThreadTimeOut(false);
        /*for (int i = 0; i < 10; i++) {
            test.threadPoolExecutor.execute(() -> {
                        System.out.println(Thread.currentThread().getName());
                    }
            );
            if(i==4){
                try {
                    System.out.println("睡眠15s");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/



       /* float f = 0.1f;
        double d = 1.0/10;
        System.out.println(f==d);   //false

        float d1 = 423432434f;
        float d2 = d1+1;
        if(d1==d2){
            System.out.println("d1==d2");
        }else{
            System.out.println("d1!=d2");
        }


        String str1 = 'a' + 3 + "Hello";
        String str2 = "Hello" + 'a' + 3;

        System.out.println(str1);
        System.out.println(str2);

        BigDecimal b1 = new BigDecimal(String.valueOf(0.01));
        BigDecimal b2 = new BigDecimal(String.valueOf(0.05));
        BigDecimal b3 = new BigDecimal(String.valueOf(0.06));

        if(b1.add(b2).compareTo(b3) == 0) {
            System.out.println("两个数字相等!");
        }else {
            System.out.println("两个数字不相等!");
        }

        int a = 10;
        a= a++ +a+++a;
        System.out.println(a);

        int [][] aa = new int [3][3];
        aa[0][2] = 1;
        System.out.println(aa);*/
    }
}
