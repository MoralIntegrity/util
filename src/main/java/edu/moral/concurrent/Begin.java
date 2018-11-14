package edu.moral.concurrent;

import java.util.concurrent.*;

/**
 * Created with default template
 *
 * @author : MoralIntegrity
 * @date : 2018-11-08 9:47
 * description : util edu.moral.concurrent class Begin
 */
public class Begin {

    public static void main(String...args){

        ExecutorService service = new ThreadPoolExecutor(10,10 , 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println(service);

        Task task = new Task();

        for(int i= 0 ; i < 100 ; i++){

            service.execute(task);

        }

        System.out.println(service);
        service.shutdown();
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " service .");
        }
    }
}
