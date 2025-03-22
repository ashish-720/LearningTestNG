package pack17_TestingDasCase;

import org.testng.annotations.Test;

public class CM1 {

    @Test(priority = 0)
    public void cm11() {
        System.out.println("In cm11");
    }

    @Test(priority = 1)
    public void cm12() {
        System.out.println("In cm12");
    }

    @Test(priority = 2)
    public void cm13() {
        System.out.println("In cm13");
    }
}
