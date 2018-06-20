package coding;

public class DeadLockDemo {
    static Object ob1=new Object();
    static Object ob2=new Object();
    public static class thread1 implements Runnable{

        @Override
        public void run() {
            synchronized (ob1){
                System.out.println("......");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (ob2){
                    System.out.println("!!!!!");
                }
            }
        }
    }

    public static class thread2 implements Runnable{

        @Override
        public void run() {
            synchronized (ob2){
                System.out.println("111111");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (ob1){
                    System.out.println("22222");
                }
            }
        }
    }

    public static void main(String[] args) {
        thread1 t1=new thread1();
        thread2 t2=new thread2();
        new Thread(t1).start();
        new Thread(t2).start();

    }
}
