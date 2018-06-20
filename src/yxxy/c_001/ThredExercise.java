package yxxy.c_001;

public class ThredExercise implements Runnable {

    @Override
    public synchronized void run() {
        System.out.print("hello,word");
    }
}
