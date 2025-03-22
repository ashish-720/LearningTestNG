package pack10_dependsOnMethodsInTestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependsOnMethodsConcept7 {
    //createShipment is ignored or deleted, will get TestNGException, but still we want to run the other two
    static String shipmentID;

    @Ignore
    @Test
    public void createShipment() {
        System.out.println(5/0);
        System.out.println("Shipment created");
        shipmentID = "wertquyer";
    }

    @Test(dependsOnMethods = {"createShipment"}, ignoreMissingDependencies = true)
    public void trackShipment() throws Exception {
        if (shipmentID != null)
            System.out.println("Shipment is tracked properly on id " + shipmentID);
        else
            throw new Exception("Shipment id is null");
    }

    @Test(dependsOnMethods = {"createShipment","trackShipment"}, ignoreMissingDependencies = true,alwaysRun = true)
    public void cancelShipment() throws Exception {
        if (shipmentID != null)
            System.out.println("Shipment is cancelled properly on id " + shipmentID);
        else
            throw new Exception("Shipment id is null");
    }
}
