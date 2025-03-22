package pack17_TestingDasCase;

import org.testng.annotations.Test;

public class CM2 {

    @Test(priority = 0)
    public void cm21() {
        System.out.println("In cm21");
    }

    @Test(priority = 1)
    public void cm22() {
        System.out.println("In cm22");
    }

    @Test(priority = 2)
    public void cm23() {
        System.out.println("In cm23");
    }
}
