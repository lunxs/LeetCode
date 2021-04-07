package com.lunx.test;

import com.lunx.model.ElvisDemo;
import com.lunx.model.Play;
import org.springframework.beans.BeanUtils;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author desong.xie
 * @version 1.0
 * @title JavaTest
 * @date 2019/09/09
 * @description
 */
public class ThreadPoolDemo {

    private static ExecutorService executorService = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), new DefaultThreadFactory1());
//    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    private static void test() {
        Play play = new Play();
        play.setId(2);

        Play p = new Play();
        BeanUtils.copyProperties(play, p);
        p.setAge(3);

        System.out.println(play);
        System.out.println(p);
    }

    private static void test1() {
        ElvisDemo e1 = ElvisDemo.getInstance();
        e1.setId(1);
        System.out.println(e1);

        ElvisDemo e2 = ElvisDemo.getInstance();
        e2.setName("bb");
        System.out.println(e2);

    }

    public static void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }

        System.out.println(param);
    }

    private static void sum() {
        long startTime = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }

//        System.out.println(sum);

        long endTime = System.currentTimeMillis();

        System.out.println(Thread.currentThread().getName());
        System.out.println("runtime:" + (endTime - startTime) + "ms");
    }

    private static void threadSingle() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            sum();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("single runtime:" + (endTime - startTime) + "ms");
    }

    public static void threadPool() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
//            executorService.submit(() -> sum());
            executorService.execute(() -> System.out.println(1));
        }


//        executorService.shutdown();

        long endTime = System.currentTimeMillis();
        System.out.println("pool runtime:" + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {
        /*try {
            threadPool();

            System.out.println("first end");
            Thread.sleep(10000L);
            System.out.println("second start");

            threadPool();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            System.out.println("***************");
//            threadSingle();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }*/

        executorService.execute(() -> exceptionTest());
        Future<?> submit = executorService.submit(() -> exceptionTest());

        try {
            submit.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void exceptionTest() {
        System.out.println("exception test");
        throw new RuntimeException("exception test");
    }

    static class DefaultThreadFactory1 implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory1() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();

            long time = System.currentTimeMillis();
            namePrefix = "pool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-" + time + "-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

}
