package pack10_dependsOnMethodsInTestNG;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept1 {
    //problem with priority, if create shipment failed and shipment id was not generated then why to run other two which are dependent
    //on shipment id
    /*
    *   ===============================================
        Default Suite
        Total tests run: 3, Failures: 3, Skips: 0
        ===============================================
    * */
    static String shipmentID;

    @Test(priority = 1)
    public void createShipment() {
        System.out.println(5 / 0);
        System.out.println("Shipment created");
        shipmentID = "wertquyer";
    }

    @Test(priority = 2)
    public void trackShipment() throws Exception {
        if (shipmentID != null)
            System.out.println("Shipment is tracked properly on id " + shipmentID);
        else
            throw new Exception("Shipment id is null");
    }

    @Test(priority = 3)
    public void cancelShipment() throws Exception {
        if (shipmentID != null)
            System.out.println("Shipment is cancelled properly on id " + shipmentID);
        else
            throw new Exception("Shipment id is null");
    }
}
