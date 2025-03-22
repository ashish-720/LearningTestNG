package pack15_parallelExecutionInTestNG;

import org.testng.annotations.Test;

public class TestClass2 {
    //Sequential execution- when things run one after other
    //In this case only single thread is used, and one by one every test method uses it. while thread is busy is executing
    //one test method others has to wait.
    //Issue is things will be delayed
    //Let suppose m1-10sec, m2-5sec, m3-10sec, m4-5sec. On seq run- 30sec will be consumed. But if they run in parallel
    // then 10 sec will be consumed.
    //we have to use testng xml file to run the things in parallel
    @Test
    public void m5() {
        System.out.println("TestClass2 >> m5 >> " + Thread.currentThread().getId());
    }

    @Test
    public void m6() {
        System.out.println("TestClass2 >> m6 >> " + Thread.currentThread().getId());
    }

    @Test
    public void m7() {
        System.out.println("TestClass2 >> m7 >> " + Thread.currentThread().getId());
    }

    @Test
    public void m8() {
        System.out.println("TestClass2 >> m8 >> " + Thread.currentThread().getId());
    }
}
