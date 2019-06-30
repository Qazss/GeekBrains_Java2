package TestClasses;

import Annotations.AfterSuite;
import Annotations.BeforeSuite;
import Annotations.Test;

public class TestClass {

    @BeforeSuite
    public static void method1(){
        System.out.println("method1: BeforeSuite");
    }

    @Test(priority = 2)
    public static void method2(){
        System.out.println("method2: Test (2)");
    }

    @Test(priority = 7)
    public static void method3(){
        System.out.println("method3: Test (7)");
    }

    @Test(priority = 4)
    public static void method4(){
        System.out.println("method4: Test (4)");
    }

    @Test(priority = 4)
    public static void method5(){
        System.out.println("method5: Test (4)");
    }

    public static void method6(){
        System.out.println("method6: Не должен выводиться");
    }

    @AfterSuite
    public static void method7(){
        System.out.println("method7: AfterSuite");
    }
}
