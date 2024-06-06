import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class FlightBookingPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://qaflightbooking.ccbp.tech/");

        WebElement departureCity = driver.findElement(By.id("departureCity"));
        departureCity.sendKeys("New York");

        WebElement desinationCity = driver.findElement(By.id("destinationCity"));
        desinationCity.sendKeys("Los Angeles");

        WebElement departureDate = driver.findElement(By.id("travelDate"));
        departureDate.sendKeys("01/08/2023");

        WebElement totalPassengers = driver.findElement(By.id("passengers"));
        totalPassengers.sendKeys("2");

        WebElement searchFlightsButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id("searchBtn")));


        searchFlightsButton.click();

        WebElement firstFlight = driver.findElement(By.cssSelector("input[name='flight'][value='0']"));
        firstFlight.click();



        WebElement bookNow = new  WebDriverWait(driver,Duration.ofSeconds(5))
        .until(ExpectedConditions.elementToBeClickable(By.tagName("Button")));
        bookNow.click();

        WebElement walletAmount = driver.findElement(By.tagName("p"));
        String expectedAmount = walletAmount.getText();
        System.out.println(expectedAmount);

        WebElement passwordEl = driver.findElement(By.cssSelector("input[type='password']"));
        passwordEl.sendKeys("traveler123");

        WebElement payNowButton = driver.findElement(By.tagName("button"));
        payNowButton.click();

        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));

        String expectedSuccessMg = "Booking Success!";

        System.out.println(expectedSuccessMg);

        driver.quit();

    }
}
