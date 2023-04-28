package com.bjpowernode.enum_;

public enum EnumScore {
    // 常量对象
    A("A级"){
        @Override
        public void printScore() {
            System.out.println("90-100");
        }
    },B("B级"){
        @Override
        public void printScore() {
            System.out.println("80-89");
        }
    },C("C级"){
        @Override
        public void printScore() {
            System.out.println("70-79");
        }
    },D("D级"){
        @Override
        public void printScore() {
            System.out.println("60-69");
        }
    },E("E级"){
        @Override
        public void printScore() {
            System.out.println("0-59");
        }
    };
    private String score;
    // 构造方法 默认私有
    EnumScore(){}
    EnumScore(String score){
        this.score = score;
    }
    // 打印学生的成绩等级
    public void print() {
        System.out.println(score);
    }
    // 打印学生的成绩范围
    public abstract void printScore();







































    // 成员变量
    private int age;
    // 成员方法
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    // 构造代码块
    {}
    // 静态代码块
    static {}
    // 内部类
    class Inner{}
}
