/**
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致问题，也就是说volatile不能替代synchronized
 * 运行下面的程序，并分析结果
 * @author mashibing
 */
package yxxy.c_013;

import java.util.ArrayList;
import java.util.List;

public class T {
	volatile int count = 0; //volatile只保证了可见性，并没有保证原子性。
	 void m() {
		for(int i=0; i<10000; i++) count++;
	}
	
	public static void main(String[] args) {
		T t = new T();
		//声明一个线程队列
		List<Thread> threads = new ArrayList<Thread>();
		//开10个线程，加入队列
		for(int i=0; i<10; i++) {
			threads.add(new Thread(t::m, "thread-"+i));
		}
		//主线程之外，开启10个线程
		threads.forEach((o)->o.start());
		//拉到主线程之中。目的：保证10个线程跑完之后，再打印。
		threads.forEach((o)->{
			try {
				o.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		//打印最后的结果
		System.out.println(t.count);
		
		
	}
	
}


