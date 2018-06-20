/**
 * 对比上面一个小程序，分析一下这个程序的输出
 * @author mashibing
 */

package yxxy.c_006;

public class T implements Runnable {

	private int count = 10;
	
	public synchronized void run() {
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void main(String[] args) {
		
		for(int i=0; i<5; i++) {
			T t = new T();//每开启一个线程，就new一个新的线程，对新线程中的属性进行访问。并不存在多线程的问题。
			new Thread(t, "THREAD" + i).start();
		}
	}
	
}
