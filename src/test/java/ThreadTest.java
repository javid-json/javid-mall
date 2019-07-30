public class ThreadTest {
    public static Integer count = 0;

    public static void getCount(){
        count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i< 5; i++){
                    getCount();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i< 5; i++){
                    getCount();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i< 5; i++){
                    getCount();
                }
            }
        }).start();
    }
}
