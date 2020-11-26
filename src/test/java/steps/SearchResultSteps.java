package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchResultSteps extends BaseStep{

    public SearchResultSteps() throws Exception {
    }

    @Then("I should be able to view list of Hotel Search result")
    public void iShouldBeAbleToViewListOfHotelSearchResult() throws Exception {
        getResultPage().verifyIfSearchResultDisplayed();
    }

    @When("I filter the result list by Sauna")
    public void iFilterTheResultListBySauna() throws Exception {
        getResultPage().filterBy_Sauna();
    }

    @Then("I should be able to see {string} in the list")
    public void iShouldBeAbleToSeeInTheList(String hotel) throws Exception {
        getResultPage().verifyIf_Limerick_Strand_Hotel_Is_In_The_List(hotel);
    }

    @When("I select 5 star filter")
    public void iSelectStarFilter() throws Exception {
        getResultPage().filterBy_5_Star();
    }

    @Then("I must see the {string} in the list")
    public void iMustSeeTheInTheList(String hotel) throws Exception {
        getResultPage().verifyIf_The_Savoy_Hotel_Is_In_The_List(hotel);
    }

    @And("I shouldn't see {string} in the list")
    public void iShouldnTSeeInTheList(String hotel) throws Exception {
        getResultPage().verifyIf_George_Limerick_Hotel_Is_In_The_List(hotel);
    }

    @When("I select both filters 5 star and Sauna")
    public void iSelectBothFiltersStarAndSauna() throws Exception {
        getResultPage().filterBy_Sauna();
        getResultPage().filterBy_5_Star();
    }

    @Then("I shouldn't see any of them {string} neither {string} in the list")
    public void iShouldnTSeeAnyOfThemNeitherInTheList(String hotel1, String hotel2) throws Exception {
        getResultPage().verifyIf_Both_Hotels_Are_In_The_List(hotel1, hotel2);
    }
}
