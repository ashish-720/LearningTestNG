package pack11_testMethoddependsOnGroups;

import org.testng.annotations.Test;

public class TestMethodDependsOnGroups2 {
    @Test(groups = {"smoke"})
    public void m5() {
        System.out.println("m5");
    }

    @Test(groups = {"regressions"})
    public void m6() {
        System.out.println("m6");
    }
}
