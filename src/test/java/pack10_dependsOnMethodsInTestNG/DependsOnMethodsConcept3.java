package pack10_dependsOnMethodsInTestNG;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept3 {
    //To overcome priority limitation we come up with dependsOnMethods
    //here both the depending on methods got skipped when createShipment failed
    static String shipmentID;

    @Test
    public void createShipment() {
        System.out.println("Shipment created");
        shipmentID = "wertquyer";
    }

    @Test(dependsOnMethods = {"createShipment"}, priority = 1)
    public void trackShipment() throws Exception {
        if (shipmentID != null)
            System.out.println("Shipment is tracked properly on id " + shipmentID);
        else
            throw new Exception("Shipment id is null");
    }

    @Test(dependsOnMethods = {"createShipment"}, priority = 2)
    public void cancelShipment() throws Exception {
        if (shipmentID != null)
            System.out.println("Shipment is cancelled properly on id " + shipmentID);
        else
            throw new Exception("Shipment id is null");
    }
}
