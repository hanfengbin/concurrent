package coding;
/*
* 测试  锁消除
* StringBuffer的操作都是syn的，这里测试append方法的消除（jvm自动优化）
* */
public class synchronziedTest {
    public void append(String a,String b){
        StringBuffer sb=new StringBuffer();
        sb.append(a).append(b);
    }

    public static void main(String[] args) {
        synchronziedTest st=new synchronziedTest();
        //启动预热
        for(int i=0;i<10000;i++){
            i++;
        }
        //
        long start=System.currentTimeMillis();
        for (int i = 0; i <100000; i++) {
            st.append("abc","def");
            
        }
        System.out.println("time:"+(System.currentTimeMillis()-start));
    }
}
