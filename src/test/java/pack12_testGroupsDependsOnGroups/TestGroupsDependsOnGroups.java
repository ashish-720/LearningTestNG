package pack12_testGroupsDependsOnGroups;

import org.testng.annotations.Test;

public class TestGroupsDependsOnGroups {

    @Test(groups = {"smoke"})
    public void m1() {
        System.out.println("smoke m1");
    }

    @Test(groups = {"sanity"})
    public void m2() {
        System.out.println("sanity m2");
    }

    @Test(groups = {"smoke"})
    public void m3() {
        System.out.println("smoke m3");
    }

    @Test(groups = {"sanity"})
    public void m4() {
        System.out.println("sanity m4");
    }

    @Test(groups = {"regressions"})
    public void m5() {
        System.out.println("regressions m5");
    }
}
