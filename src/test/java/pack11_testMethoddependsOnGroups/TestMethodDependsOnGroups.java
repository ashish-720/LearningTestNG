package pack11_testMethoddependsOnGroups;

import org.testng.annotations.Test;

public class TestMethodDependsOnGroups {
    @Test(groups = {"smoke"})
    public void m4() {
        System.out.println("m4");
    }

    @Test(groups = {"regressions"})
    public void m2() {
        System.out.println(5/0);
        System.out.println("m2");
    }

    @Test(groups = {"smoke", "sanity", "regressions"})
    public void m3() {
        System.out.println("m3");
    }

    @Test(dependsOnGroups = {"smoke", "regressions"})
    public void m1() {
        System.out.println("m1");
    }
}
