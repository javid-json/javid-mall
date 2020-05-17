package pers.javid.mall.utils;

//import org.apache.tomcat.jni.Lock;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：javid
 * @date ：Created in 2019-8-16
 * @description：单据号生成工具类
 * @version: 1.0
 */
public class GenerateNoUtils {
    private final static AtomicInteger ATOMIC_INTEGER = new AtomicInteger(1);
    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String generateOrderNo(){
        StringBuffer sb = new StringBuffer(1);
        sb.append(ATOMIC_INTEGER.getAndIncrement());
        return sb.toString();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Set<String> set = new HashSet<String>();
        FutureTask<String> task;
        for(int i = 0; i < 10000; i++){
            Callable<String> callable = () -> {
                    return generateOrderNo();
            };
            task = new FutureTask<>(callable);
            new Thread(task).start();
            set.add(task.get());
        }
        System.out.println(set.size());
    }
}
