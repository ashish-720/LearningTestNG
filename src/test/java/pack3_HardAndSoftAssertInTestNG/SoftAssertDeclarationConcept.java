package pack3_HardAndSoftAssertInTestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDeclarationConcept {
    //The Problem when soft assert is shared across test methods
    SoftAssert soft = new SoftAssert();

    @Test
    public void m1(){
        soft.assertEquals(3,4, "Integer is matching - >");
        soft.assertFalse(true, "Is Result False ? ");
//        soft.assertAll();
    }

    @Test
    public void m2(){
        soft.assertTrue(false, "Is Results True ? ");
        soft.assertNotNull(null, "Is Object Not Null ? ");
        soft.assertAll();
    }
}
