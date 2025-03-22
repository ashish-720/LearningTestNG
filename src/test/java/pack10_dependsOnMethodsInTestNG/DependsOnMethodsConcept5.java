package pack10_dependsOnMethodsInTestNG;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept5 {
    //alwaysRun=true, if we want to run the dependent methods even if there is a failure in createShipment
    static String shipmentID;

    @Test
    public void createShipment() {
        System.out.println(5/0);
        System.out.println("Shipment created");
        shipmentID = "wertquyer";
    }

    @Test(dependsOnMethods = {"createShipment"}, alwaysRun = true)
    public void trackShipment() throws Exception {
        if (shipmentID != null)
            System.out.println("Shipment is tracked properly on id " + shipmentID);
        else
            throw new Exception("Shipment id is null");
    }

    @Test(dependsOnMethods = {"createShipment","trackShipment"}, alwaysRun = true)
    public void cancelShipment() throws Exception {
        if (shipmentID != null)
            System.out.println("Shipment is cancelled properly on id " + shipmentID);
        else
            throw new Exception("Shipment id is null");
    }
}
