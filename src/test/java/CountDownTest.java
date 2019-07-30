import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownTest{
    static CountDownLatch latch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++){
            final int index = i+1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("check"+index);
                    try{
                        Thread.sleep(1000);
                        latch.countDown();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        latch.await();
        System.out.println("begin start");
        exec.shutdown();
    }
}
