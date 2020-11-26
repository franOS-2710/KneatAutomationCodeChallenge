package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps extends BaseStep{

    public HomeSteps() throws Exception {
    }

    @Given("I am navigated to Booking")
    public void iAmNavigatedToBooking() throws Exception {
        getHomePage().launchApp();
        Assert.assertEquals(true,getHomePage().ifNavigatedToBooking());
    }

    @When("^I provide (.*?) Hotel Booking Information$")
    public void iProvideDestinationHotelBookingInformation(String dataset) throws Exception {
        getHomePage().addBookingInformationForSearch(data(dataset).get("location"));
    }

}
