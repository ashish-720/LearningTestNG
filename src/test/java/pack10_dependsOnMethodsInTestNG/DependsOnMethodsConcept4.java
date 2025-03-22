package pack10_dependsOnMethodsInTestNG;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept4 {
    //Compare to priority an dependsOnMethods, priority will have the least precedence
    static String shipmentID;

    @Test(priority = 2)
    public void createShipment() {
        System.out.println("Shipment created");
        shipmentID = "wertquyer";
    }

    @Test(priority = 1, dependsOnMethods = {"createShipment"})
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
