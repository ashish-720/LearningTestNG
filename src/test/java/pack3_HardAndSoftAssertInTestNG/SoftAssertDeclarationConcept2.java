package pack3_HardAndSoftAssertInTestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDeclarationConcept2 {
    //Proper use of Soft Assert

    SoftAssert softAssert;

    @Test
    public void m1() {
        softAssert = new SoftAssert();
        softAssert.assertTrue(true);
        softAssert.assertEquals("ashish","ashish");
        softAssert.assertAll();
    }


    @Test
    public void m2() {
        softAssert = new SoftAssert();
        softAssert.assertTrue(true);
        softAssert.assertEquals("ashish","ashish");
        softAssert.assertAll();
    }
}
