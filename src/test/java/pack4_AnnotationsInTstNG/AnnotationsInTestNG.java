package pack4_AnnotationsInTstNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsInTestNG {
    @Test
    public void test1() {
        System.out.println("In Test Method1");
    }

    @Test
    public void test2() {
        System.out.println("In Test Method2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("In Before Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("In Before class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("In Before Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("In Before Suite");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("In after Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("In After class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("In After Test");
    }

    @AfterSuite
    public void AfterSuite() {
        System.out.println("In After Suite");
    }

}
