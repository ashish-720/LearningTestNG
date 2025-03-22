package pack9_GroupingInTestNG;

import org.testng.annotations.Test;

public class GroupConceptClass2 {
    @Test(groups = {"sanity", "smoke"})
    public void m5() {
        System.out.println("m5 part of smoke, sanity");
    }

    @Test(groups = {"regressions", "smoke"})
    public void m6() {
        System.out.println("m6 part of smoke, regressions");
    }

    @Test
    public void m7() {
        System.out.println("m7 part of none of the groups");
    }

    @Test(groups = {"functional"})
    public void m8() {
        System.out.println("m8 part of functional");
    }
}
