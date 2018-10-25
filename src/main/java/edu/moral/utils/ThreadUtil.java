package edu.moral.utils;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created with default template
 *
 * @author : MoralIntegrity
 * @date : 2018-10-23 9:43
 * description : util edu.moral.utils class ThreadUtil
 */
public class ThreadUtil {

    public static void main(String...args) throws Exception{

        LocalThread local = new LocalThread();

        List<Thread> thread = Lists.newArrayList();


        for(int i=0;i< 10; i++){
            thread.add(new Thread(() -> local.invoke()));
        }


        thread.forEach(i -> i.start());

        thread.forEach(i -> {
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(local.count);

    }
}

class LocalThread {

    /*volatile*/ int count = 0;

    public void invoke() {

        for(int i=0;i< 10000; i++){
            count ++;
        }

    }

}
