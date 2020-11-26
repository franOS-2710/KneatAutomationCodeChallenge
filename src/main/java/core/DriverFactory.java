package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private WebDriver driver = null;

    public WebDriver getDriver(String browserName) {

        switch(browserName.toLowerCase()) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/playon-03/Desktop/Driver/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/Users/playon-03/Desktop/Driver/geckodriver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

            case "safari":
                driver = new SafariDriver();
                driver.manage().window().maximize();
                break;

            default: System.out.println("Incorrect browser name provided " +browserName);
                System.out.println("Hence running in Chrome");
                System.setProperty("webdriver.chrome.driver", "/Users/playon-03/Desktop/Driver/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
        }

        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(TestConfig.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("implicitWait")), TimeUnit.SECONDS);
        return driver;
    }

    public void quitDriver() {
        if(driver!=null) {
            driver.quit();
        }
    }
}
