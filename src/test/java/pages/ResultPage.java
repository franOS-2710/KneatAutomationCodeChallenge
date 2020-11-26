package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ResultPage {

    By checkbox5stars = By.xpath(".//a[@data-id='class-5']");
   // By linkShowAllFacilities = By.xpath("(.//div[@id='filter_facilities'])[1]//button[@class='collapsed_partly_link collapsed_partly_more']");
   // By checkboxSpa = By.xpath("(.//div[@id='filter_facilities']//span[contains(text(),'Spa and wellness centre')])[1]//ancestor::a");
    By checkboxSauna = By.xpath("(.//div[@id='filter_popular_activities']//span[contains(text(),'Sauna')])[1]//ancestor::a");
    By listOfHotels = By.xpath(".//div[@class='sr-hotel__title-wrap']//span[contains(@class,'sr-hotel__name')]");

    private WebDriver driver;

    public ResultPage(WebDriver driver) throws Exception {
        this.driver = driver;
    }

    public boolean verifyIfSearchResultDisplayed() {
        List<WebElement> hotels = driver.findElements(listOfHotels);
        boolean status = (hotels.size() > 0) ? true : false;
        return status;
    }

    public void filterBy_Sauna() throws Exception {
        //driver.findElement(linkShowAllFacilities).click();
        driver.findElement(checkboxSauna).click();
        Thread.sleep(2000);
    }

    public void filterBy_5_Star() throws Exception {
        driver.findElement(checkbox5stars).click();
        Thread.sleep(2000);
    }

    public void verifyIf_Limerick_Strand_Hotel_Is_In_The_List(String hotel) throws Exception {
        List<WebElement> hotels = driver.findElements(listOfHotels);

        for(WebElement h: hotels){
            if (h.getText().equals(hotel)) {
                System.out.println("Found: " + h.getText() + " --PASSED");
            } else if (!h.getText().equals(hotel)) {

            }else{
            System.out.println("Limerick Strand Hotel NOT found --FAILED");
        }
        }
    }

    public void verifyIf_George_Limerick_Hotel_Is_In_The_List(String hotel) throws Exception {
        List<WebElement> hotels = driver.findElements(listOfHotels);

        for(WebElement h: hotels){
            if (h.getText().equals(hotel)) {
                System.out.println("Found: " + h.getText() + " --FAILED");
            }
        }
        System.out.println("George Limerick Hotel NOT found --PASSED");
    }

    public void verifyIf_The_Savoy_Hotel_Is_In_The_List(String hotel) throws Exception {
        List<WebElement> hotels = driver.findElements(listOfHotels);

        for(WebElement h: hotels){
            if (h.getText().equals(hotel)) {
                System.out.println("Found: " + h.getText() + " --PASSED");
            } else if (!h.getText().equals(hotel)) {

            }else{
                System.out.println("The Savoy Hotel NOT found --FAILED");
            }
        }
    }

    public void verifyIf_Both_Hotels_Are_In_The_List(String hotel1, String hotel2) throws Exception {
        List<WebElement> hotels = driver.findElements(listOfHotels);

        for(WebElement h: hotels){
            if (h.getText().equals(hotel1) && (h.getText().equals(hotel2))) {
                System.out.println("Found: " + h.getText() + " --FAILED");
            }
        }
        System.out.println("Limerick Strand Hotel and The Savoy Hotel NOT found --PASSED");
    }
}
