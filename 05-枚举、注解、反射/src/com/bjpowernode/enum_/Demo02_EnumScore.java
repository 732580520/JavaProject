package com.bjpowernode.enum_;

public class Demo02_EnumScore {
    public static void main(String[] args) {
        // 获取枚举的对象
        EnumScore a = EnumScore.A;
        System.out.println("a = " + a);
        a.print();
        a.printScore();
        EnumScore b = EnumScore.B;
        System.out.println("b = " + b);
        b.print();
        b.printScore();
        EnumScore c = EnumScore.C;
        System.out.println("c = " + c);
        c.print();
        c.printScore();
        EnumScore d = EnumScore.D;
        System.out.println("d = " + d);
        d.print();
        d.printScore();
        EnumScore e = EnumScore.E;
        System.out.println("e = " + e);
        e.print();
        e.printScore();

        /*
            int ordinal​() 返回此枚举常数的序数（其枚举声明中的位置，其中初始常数的序数为零）。
	        int compareTo​(E o) 将此枚举与指定的对象进行比较以进行订购。
        */
        int ordinalA = a.ordinal();
        System.out.println("ordinalA = " + ordinalA);
        int ordinalB = b.ordinal();
        System.out.println("ordinalB = " + ordinalB);

        System.out.println( e.compareTo(c) );
    }
}
