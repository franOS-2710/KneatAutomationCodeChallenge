package pages;

import core.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HomePage{

    By txtDestination = By.xpath(".//input[@class='c-autocomplete__input sb-searchbox__input sb-destination__input']");
    By firstSuggestionForDestination = By.xpath(".//ul[@aria-label='List of suggested destinations ']/li[1]");
    By datePickerMonthTitle = By.xpath("(.//div[@class='bui-calendar__month'])[1]");
    By datePickerNextButton = By.xpath(".//div[@class='bui-calendar__control bui-calendar__control--next']");
    By btnSearch = By.xpath(".//button[@class='sb-searchbox__button ']");

    private WebDriver driver;

    public HomePage(WebDriver driver) throws Exception {
        this.driver = driver;
    }

    public void launchApp() throws InterruptedException {
        driver.get(TestConfig.getProperty("appBaseURL"));
        Thread.sleep(2000);
        //Accepting cookies
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    public boolean ifNavigatedToBooking(){
        return driver.findElement(txtDestination).isDisplayed();
    }

    public void addBookingInformationForSearch(String destination) throws Exception {
        driver.findElement(txtDestination).sendKeys(destination);
        driver.findElement(firstSuggestionForDestination).click();
        handleCalendars(getDate_3_months_from_today());
        handleCalendars(getDate_One_night_stay());
        driver.findElement(btnSearch).click();
    }

    public void handleCalendars(String date) throws Exception {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String expectedMonth = localDate.getMonth().name().toLowerCase();
        String expectedYear = String.valueOf(localDate.getYear());
        String expectedDay = String.valueOf(localDate.getDayOfMonth());

        //Month Navigation
        while (!expectedMonth.equals(driver.findElement(datePickerMonthTitle).getText().split(" ")[0].toLowerCase())
                || !expectedYear.equals(driver.findElement(datePickerMonthTitle).getText().split(" ")[1])) {
            driver.findElement(datePickerNextButton).click();
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("(.//table[@class='bui-calendar__dates'])[1]//span[text()="+expectedDay+"]")).click();
    }

    public String getDate_3_months_from_today(){
        LocalDate today = LocalDate.now();
        String add3month = String.valueOf(today.plusMonths(3));
        return add3month;
    }

    public String getDate_One_night_stay(){
        LocalDate date = LocalDate.parse(getDate_3_months_from_today());
        String checkoutDate = String.valueOf(date.plusDays(1));
        return checkoutDate;
    }
}
