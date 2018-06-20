package yxxy.MyselfExercise;

import java.awt.*;

public class testStringSame {
    public static void main(String[] args){
        String s=new String("hello");
        String s1=new String("hello");

        Integer a=new Integer(1);
        Integer b=new Integer(1);

        System.out.println(s==s1);//==用于判断地址是否相等
        System.out.println(s.equals(s1));//equals用于判断内容是否相等。

    }
}
