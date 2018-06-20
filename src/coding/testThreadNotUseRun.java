package coding;

import java.util.concurrent.TimeUnit;

public class testThreadNotUseRun {
    public static class thread1{
        public void m(){
            for(int i=0;i<100;i++){
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        thread1 t1=new thread1();
        new Thread(t1::m).start();
    }
}
