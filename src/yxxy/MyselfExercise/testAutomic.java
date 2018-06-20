package yxxy.MyselfExercise;

import java.util.concurrent.atomic.AtomicInteger;

public class testAutomic implements Runnable {
    AtomicInteger ai=new AtomicInteger(0);

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ai.get()%5==0){
                System.out.println(i);

            }
        }
    }
    public static void main(String[] args){
        testAutomic ta=new testAutomic();
        new Thread(ta,"ta").start();
        ta.ai=new AtomicInteger(10);


    }

}
