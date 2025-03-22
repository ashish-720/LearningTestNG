package pack8_IgnoreConceptInTestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreSpecificTestMethodsInTestNG {
    @Test
    public void m1() {
        System.out.println("In m1");
    }

    //First way
    @Test(enabled = false)
    public void m2() {
        System.out.println("In m2");
    }

    //2nd way
    @Ignore
    @Test
    public void m3() {
        System.out.println("In m3");
    }

    @Ignore            //here ignore will get the highest precedence
    @Test(enabled = true)
    public void m4() {
        System.out.println("In m4");
    }

    @Test
    public void m5() {
        System.out.println("In m5");
    }
}
