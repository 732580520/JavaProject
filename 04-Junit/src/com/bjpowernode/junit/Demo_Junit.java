package com.bjpowernode.junit;
import org.junit.*;
/*
    junit测试工具:给开发人员使用的，不依赖main方法运行程序，查看程序的运行结果。
    测试工程师:使用更加专业的测试工具。
    黑盒测试:只关注程序的运行结果是否满足客户的需求，不关注实现过程。
    白盒测试:只关注程序的实现过程，不关注是否满足客户的需求。  优化程序

    1.定义一个方法
    2.在方法上添加一个@Test注解  前提：程序中没有Test类存在  @After  @Before
    3.使用代码补全快捷键 快速添加即可

    @Test注解：只能运行无参，无返回值的非静态方法。
    @After注解：在每个Test注解的方法运行结束之后，都会跟着运行。
    @Before注解：在每个Test注解的方法运行之前，都会跟着运行。
    @AfterClass：在所有的方法运行结束之后，只执行一次。
    @BeforeClass：在所有的方法运行之前运行，只执行一次。
*/
public class Demo_Junit {
    @Test
    public void show() {
        System.out.println("show run...");
    }

    @Test
    public void show2() {
        add(10,100);
        System.out.println("show2 run...");
    }

    public void add(int a,int b) {
        System.out.println(a + b);
    }

    public void show3() {
        System.out.println("show3 run...");
    }
    @After
    public void after() {
        System.out.println("after run...");
    }
    @Before
    public void before() {
        System.out.println("before run...");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass run...");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass run...");
    }

}
