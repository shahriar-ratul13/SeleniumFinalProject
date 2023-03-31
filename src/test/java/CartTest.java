import common.Setup;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CartPage;

import static org.testng.Assert.*;
// 8 test
public class CartTest extends Setup {

    CartPage cart;

    @BeforeMethod // Open a new browser window for each test
    void initializeTest() {
        // Open the page for testing
        openBrowser("https://www.costco.com/grocery-household.html");
        // Initialize the web elements from the class as objects
        cart = PageFactory.initElements(driver, CartPage.class);
    }

    @AfterMethod // Close all browser windows
    void exitBrowser() {
        closeBrowser();
    }

    @AfterTest // Close all driver instances after tests are completed
    void exitDriver() {
        quitDriver();
    }

    @Test // Check if item has number added below it after cart addition
    void testCartSearch() {
        cart.searchCostco("Kirkland Signature Nature's Domain Salmon & Sweet Potato");
        cart.clickSearchButton();
        cart.clickQuantityButton(driver);
        cart.clickAddToCartSearch(driver);
        assertTrue(cart.itemInCartDisplayed(driver));
    }

    @Test // Check if search item appears
    void testItemSearchDisplay() {
        cart.searchCostco("Kind Mini Bars, Variety Pack, 0.7 oz, 36-count");
        cart.clickSearchButton();
        assertTrue(cart.searchItemDisplayed(driver));
    }

    @Test // Test if small icon with quantity in cart pops up
    void testCartAmountIconDisplay() {
        cart.searchCostco("Kirkland Signature Nature's Domain Salmon & Sweet Potato");
        cart.clickSearchButton();
        cart.clickQuantityButton(driver);
        cart.clickAddToCartSearch(driver);
        assertTrue(cart.cartAmountIconDisplayed(driver));
    }

    @Test // Test if items are visible in Cart page
    void testCartButton() {
        cart.searchCostco("Kirkland Signature Nature's Domain Salmon & Sweet Potato");
        cart.clickSearchButton();
        cart.clickQuantityButton(driver);
        cart.clickAddToCartSearch(driver);
        explicitWaitVisible(driver, cart.cartAmountIcon);
        cart.clickCartButton();
        assertTrue(cart.removeItemDisplayed(driver));
    }

    @Test
    void testCartFromItemPageCartButtonDisplay() {
        cart.searchCostco("Kind Mini Bars, Variety Pack, 0.7 oz, 36-count");
        cart.clickSearchButton();
        cart.clickFirstSearchItem(driver);
        assertTrue(cart.addToCartItemPageDisplayed(driver));
    }

    @Test
    void testViewCartButtonDisplay() {
        cart.searchCostco("Kind Mini Bars, Variety Pack, 0.7 oz, 36-count");
        cart.clickSearchButton();
        cart.clickFirstSearchItem(driver);
        cart.clickAddToCartItemPage(driver);
        assertTrue(cart.viewCartDisplayed(driver));
    }

    @Test
    void testContinueShoppingButtonDisplay() {
        cart.searchCostco("Kind Mini Bars, Variety Pack, 0.7 oz, 36-count");
        cart.clickSearchButton();
        cart.clickFirstSearchItem(driver);
        cart.clickAddToCartItemPage(driver);
        assertTrue(cart.continueShoppingDisplayed(driver));
    }

    @Test
    void testGotoCartFromItemPage() {
        cart.searchCostco("Kind Mini Bars, Variety Pack, 0.7 oz, 36-count");
        cart.clickSearchButton();
        cart.clickFirstSearchItem(driver);
        cart.clickAddToCartItemPage(driver);
        cart.clickViewCart(driver);
        assertTrue(cart.cartCheckoutButtonDisplayed(driver));
    }
}
