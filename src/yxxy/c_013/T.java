/**
 * volatile�����ܱ�֤����̹߳�ͬ�޸�running����ʱ�������Ĳ�һ�����⣬Ҳ����˵volatile�������synchronized
 * ��������ĳ��򣬲��������
 * @author mashibing
 */
package yxxy.c_013;

import java.util.ArrayList;
import java.util.List;

public class T {
	volatile int count = 0; //volatileֻ��֤�˿ɼ��ԣ���û�б�֤ԭ���ԡ�
	 void m() {
		for(int i=0; i<10000; i++) count++;
	}
	
	public static void main(String[] args) {
		T t = new T();
		//����һ���̶߳���
		List<Thread> threads = new ArrayList<Thread>();
		//��10���̣߳��������
		for(int i=0; i<10; i++) {
			threads.add(new Thread(t::m, "thread-"+i));
		}
		//���߳�֮�⣬����10���߳�
		threads.forEach((o)->o.start());
		//�������߳�֮�С�Ŀ�ģ���֤10���߳�����֮���ٴ�ӡ��
		threads.forEach((o)->{
			try {
				o.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		//��ӡ���Ľ��
		System.out.println(t.count);
		
		
	}
	
}


