package coding;

public class testStaticMethodInClass {
    int i;
    String name;
    private static class A{
        private int i;
        private void m(){System.out.println("innner class");}
    }


    public void staticMethodInClass(){
        System.out.println("n");
    }

    public static void staticMethod(){

    }
    public static void main(String[] args) {
//        A a= A;
//        a.m();
    }
}
