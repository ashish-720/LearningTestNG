package pack15_parallelExecutionInTestNG;

import org.testng.annotations.Test;

public class TestClass4 {
    //Sequential execution- when things run one after other
    //In this case only single thread is used, and one by one every test method uses it. while thread is busy is executing
    //one test method others has to wait.
    //Issue is things will be delayed
    //Let suppose m1-10sec, m2-5sec, m3-10sec, m4-5sec. On seq run- 30sec will be consumed. But if they run in parallel
    // then 10 sec will be consumed.
    //we have to use testng xml file to run the things in parallel
    @Test
    public void m13() {
        System.out.println("TestClass4 >> m13 >> " + Thread.currentThread().getId());
    }

    @Test
    public void m14() {
        System.out.println("TestClass4 >> m14 >> " + Thread.currentThread().getId());
    }

    @Test
    public void m15() {
        System.out.println("TestClass4 >> m15 >> " + Thread.currentThread().getId());
    }

    @Test
    public void m16() {
        System.out.println("TestClass4 >> m16 >> " + Thread.currentThread().getId());
    }
}
