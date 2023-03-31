import common.Setup;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class iFrameDemo extends Setup {

    @BeforeMethod
        // Open a new browser window for each test
    void initializeTest() {
        // Open the page for testing
        openBrowser("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
    }

    @Test
    void iFrameTest() {
        WebElement frame1 = driver.findElement(By.id("iframeResult")); // Create new WebElement for the frame
        driver.switchTo().frame(frame1); // Swaps to the frame with the given WebElement parameter
        driver.findElement(By.xpath("/html/body/button")).click(); // Clicks on the "Try it" button

        driver.switchTo().alert().accept(); // Dismisses the alert by accepting

        String alertText = driver.findElement(By.xpath("/html/body/h2")).getText();
        Assert.assertEquals(alertText, "The alert() Method"); // Assert to check if we swapped to child frame

        driver.switchTo().parentFrame(); //  swaps back to the parent frame
        WebElement homeButton = driver.findElement(By.xpath("//a[@id='tryhome']"));
        Assert.assertTrue(homeButton.isDisplayed()); // Assert to make sure we swapped to parent frame
    }
}
