import common.Setup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;

import java.util.ArrayList;


import static org.testng.Assert.*;

// 10 tests
public class HomeTest extends Setup {

    HomePage home;

    @BeforeMethod(alwaysRun = true)
        // Open a new browser window for each test
    void initializeTest() {
        // Open the page for testing
        openBrowser("https://www.costco.com");
        // Initialize the web elements from the class as objects
        home = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterMethod(alwaysRun = true)
        // Close all browser windows
    void exitBrowser() {
        closeBrowser();
    }

    @AfterTest(alwaysRun = true)
        // Close all driver instances after tests are completed
    void exitDriver() {
        quitDriver();
    }


    @Test(priority = 1)
        // Retrieve and print title of the launched page
    void testTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome to Costco Wholesale";
        assertEquals(actualTitle, expectedTitle, "Error: Title did not match");
    }

    @Test(priority = 2)
        // Fail on purpose to test Assert
    void testTitleError() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome to Costco WholePotato";
        assertEquals(actualTitle, expectedTitle, "Error: Title did not match");
    }

    @Test(priority = 3)
        // Test search bar
    void testSearchFunction() {
        home.searchCostco("Refrigerator");
        home.clickSearchButton();
        assertTrue(home.verifySearch(driver));
    }

    @Test(enabled = false)
        // Skipping this test due to error
    void testShopMenuLinks() {
        ArrayList<String> actual = home.shopMenu();
        System.out.println(actual);
    }

    @Test (groups = "displayCheck")
    void testShopMenuDisplay() {
        boolean checkShop = home.shopDisplay(driver);
        assertTrue(checkShop);
    }

    @Test
        // Actual link page seems to vary, so the test usually fails
    void testNumberPageLinks() {
        System.out.println(home.pageLinkAmount());
        int actualLinks = home.pageLinkAmount();
        int expectedLinks = 424;
        assertEquals(actualLinks, expectedLinks);
    }

    @Test
        // Print all links on the page
    void testPrintAllLinks() {
        System.out.println(home.pageLinkAmount());
        for (WebElement link : home.allLinks) {
            System.out.println("Link Texts are: " + link.getText());
            System.out.println("Links are: " + link.getAttribute("href"));
        }
    }

    @Test
        // Printing the footers present
    void testPrintFooters() {
        for (WebElement footer : home.footers) {
            System.out.println("Footers are:\n" + footer.getText());
        }
    }

    @Test (groups = "displayCheck")
        // Test newsletter popup closing
    void testCloseEmailPopup() {
        home.closePopup(driver);
        assertFalse(home.emailPopupDisplayed());
    }

    @Test(groups = "gotoLinkCheck")
        // Check functionality of sign in page hyperlink
    void testGotoSignIn() {
        home.gotoSignIn(driver);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Sign In | Costco";
        assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void switchToDeals() {
        home.clickDeals();
        switchWindow(driver);
        String expected = "OFF  | Costco";
        assertEquals(driver.getTitle(), expected);
    }
}
