package com.bjpowernode.enum_;
/*
    多例设计模式：程序中只允许出现指定的N个对象。
    1.私有构造方法
    2.创建N个本类对象
    3.返回本类对象
    成绩：A（90-100）  B（80-89）  C（70-79）  D（60-69）  E（0-59）
*/
public abstract class Score {
    private String score;
    private Score() {}
    public Score(String score) {
        this.score = score;
    }
    private static final Score A = new Score("A级"){
        @Override
        public void printScore() {
            System.out.println("90-100");
        }
    };
    private static final Score B = new Score("B级"){
        @Override
        public void printScore() {
            System.out.println("80-89");
        }
    };
    private static final Score C = new Score("C级"){
        @Override
        public void printScore() {
            System.out.println("70-79");
        }
    };
    private static final Score D = new Score("D级"){
        @Override
        public void printScore() {
            System.out.println("60-69");
        }
    };
    private static final Score E = new Score("E级"){
        @Override
        public void printScore() {
            System.out.println("0-59");
        }
    };
    public static Score getA() {
        return A;
    }
    public static Score getB() {
        return B;
    }
    public static Score getC() {
        return C;
    }
    public static Score getD() {
        return D;
    }
    public static Score getE() {
        return E;
    }
    // 打印学生的成绩等级
    public void print() {
        System.out.println(score);
    }
    // 打印学生的成绩范围
    public abstract void printScore();
}
