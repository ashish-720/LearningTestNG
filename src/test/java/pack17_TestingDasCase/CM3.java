package pack17_TestingDasCase;

import org.testng.annotations.Test;

public class CM3 {

    @Test(priority = 0)
    public void cm31() {
        System.out.println("In cm31");
    }

    @Test(priority = 1)
    public void cm32() {
        System.out.println("In cm32");
    }

    @Test(priority = 2)
    public void cm33() {
        System.out.println("In cm33");
    }
}
