/**
 * 分析一下这个程序的输出
 * @author mashibing
 */

package yxxy.c_005;

public class T implements Runnable {

	private int count = 10;
	
	public synchronized void run() {
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void main(String[] args) {
		T t = new T();//这里正确的理解应该为：new出来一个T对象，
		for(int i=0; i<5; i++) {
			new Thread(t, "THREAD" + i).start();//这行代码的正确理解：启动五个线程，同时访问t中的资源。
		}
	}
	
}
