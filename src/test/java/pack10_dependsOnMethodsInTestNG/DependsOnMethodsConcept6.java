package pack10_dependsOnMethodsInTestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependsOnMethodsConcept6 {
    //createShipment is ignored or deleted, will get TestNGException
    static String shipmentID;

    @Ignore
    @Test
    public void createShipment() {
        System.out.println(5/0);
        System.out.println("Shipment created");
        shipmentID = "wertquyer";
    }

    @Test(dependsOnMethods = {"createShipment"})
    public void trackShipment() throws Exception {
        if (shipmentID != null)
            System.out.println("Shipment is tracked properly on id " + shipmentID);
        else
            throw new Exception("Shipment id is null");
    }

    @Test(dependsOnMethods = {"createShipment","trackShipment"})
    public void cancelShipment() throws Exception {
        if (shipmentID != null)
            System.out.println("Shipment is cancelled properly on id " + shipmentID);
        else
            throw new Exception("Shipment id is null");
    }
}
