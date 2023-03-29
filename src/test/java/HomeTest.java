import common.Setup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HomeTest extends Setup {

    HomePage home;


    @BeforeMethod // Open a new browser window for each test
    void initializeTest() {
        // Open the page for testing
        openBrowser("https://www.costco.com");
        // Initialize the web elements from the class as objects
        home = PageFactory.initElements(driver, HomePage.class);
        // Implicitly wait 10s
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest // Close all windows/driver instances after tests are completed
    void exitBrowser() {
        quitBrowser();
    }


    @Test (priority = 1) // Retrieve and print title of the launched page
    void testTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome to Costco Wholesale";
        Assert.assertEquals(actualTitle, expectedTitle, "Error: Title did not match");
    }

    @Test (priority = 2) // Fail on purpose to test Assert
    void testTitleError() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome to Costco WholePotato";
        Assert.assertEquals(actualTitle, expectedTitle, "Error: Title did not match");
    }

    @Test (priority = 3) // Test search bar
    void testSearchFunction() {
        home.searchCostco("Refrigerator");
        home.clickSearchButton();
    }

    @Test (enabled = false) // Skipping this test due to error
    void testShopMenuLinks() {
        ArrayList<String> actual = home.shopMenu();
        System.out.println(actual);
    }

    @Test
    void testShopMenuDisplay() {
        boolean checkShop = home.shopDisplay(driver);
        Assert.assertTrue(checkShop);
    }

    @Test // Actual link page seems to vary, so the test usually fails
    void testNumberPageLinks() {
        System.out.println(home.pageLinkAmount());
        int actualLinks = home.pageLinkAmount();
        int expectedLinks = 430;
        Assert.assertEquals(actualLinks, expectedLinks);
    }

    @Test // Test newsletter popup closing
    void closeEmailPopup() {
        home.closePopup(driver);
    }

}
