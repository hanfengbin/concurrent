package coding;

public class testTryAndFinally {
    public static void main(String[] args) {
        System.out.println("return the value of getValue()"+getValue());
    }
    public static int getValue(){
        try{
            return 0;
        }finally{
            return 1;
        }
    }
}
