package pack9_GroupingInTestNG;

import org.testng.annotations.Test;

public class GroupConceptClass1 {

    @Test(groups = {"smoke"})
    public void m1(){
        System.out.println("m1 part of smoke");
    }
    @Test(groups = {"regressions","smoke"})
    public void m2(){
        System.out.println("m2 part of smoke, regressions");
    }
    @Test(groups = {"functional","sanity"})
    public void m3(){
        System.out.println("m3 part of functional,sanity ");
    }
    @Test
    public void m4(){
        System.out.println("m4 part of non of the groups");
    }
}
