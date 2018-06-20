package coding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestFailFast {
    private static List<Integer> list=new ArrayList<Integer>();

    private static class threadOne extends Thread{
        @Override
        public void run() {
            Iterator<Integer> it=list.iterator();
            while(it.hasNext()){
                int i=it.next();
                System.out.println("Thread1:"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class threadTwo extends Thread{
        @Override
        public void run(){
            int i=0;
            while(i<6){
                System.out.println("Threa two:"+i);
                if(i==3){
                    list.remove(i);
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            list.add(i);
        }
        new threadOne().start();
        new threadTwo().start();
        //CopyOnWriteArrayList
    }
}
