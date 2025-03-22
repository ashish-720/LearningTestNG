package pack8_IgnoreConceptInTestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class IgnoreWholeTestClass {
    @Test
    public void m1() {
        System.out.println("In m1");
    }

    @Test
    public void m2() {
        System.out.println("In m2");
    }

    @Test
    public void m3() {
        System.out.println("In m3");
    }

    @Test
    public void m4() {
        System.out.println("In m4");
    }

    @Test
    public void m5() {
        System.out.println("In m5");
    }
}
