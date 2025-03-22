package pack7_PriorityInTestNG;

import org.testng.annotations.Test;

public class PriorityCaseStudy {
    //MakeMyTripBooking

    @Test(priority = 1)
    public void navigateToWebSite() {
        System.out.println("Navigate to Make my trip");
    }

    @Test(priority = 2)
    public void createAnAccount() {
        System.out.println("createAnAccount on Make my trip");
    }

    @Test(priority = 3)
    public void login() {
        System.out.println("login to Make my trip");
    }

    @Test(priority = 4)
    public void searchForFlight() {
        System.out.println("Search for flight in Make my trip");
    }

    @Test(priority = 5)
    public void bookAnTicket() {
        System.out.println("Book a ticket in Make my trip");
    }

    @Test(priority = 6)
    public void downloadTheTicket() {
        System.out.println("Download the ticket from Make my trip");
    }

    @Test(priority = 7)
    public void logout() {
        System.out.println("Logout from Make my trip");
    }
}
