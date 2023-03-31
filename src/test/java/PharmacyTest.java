import common.Setup;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.PharmacyPage;


import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

// 14 tests
public class PharmacyTest extends Setup {

    PharmacyPage pharmacy;

    @BeforeMethod(alwaysRun = true)
        // Open a new browser window for each test
    void initializeTest() {
        // Open the page for testing
        openBrowser("https://www.costco.com/pharmacy/warehouse-pickup");
        // Initialize the web elements from the class as objects
        pharmacy = PageFactory.initElements(driver, PharmacyPage.class);

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

    @Test(groups = "enabledCheck")
    void testRefillButtonEnabled() {
        assertTrue(pharmacy.refillButtonEnabled());
    }

    @Test(groups = "enabledCheck")
    void testWarehouseLocatorEnabled() {
        assertTrue(pharmacy.warehouseLocatorEnabled());
    }

    @Test(groups = "enabledCheck")
    void testDrugPricesLinkEnabled() {
        assertTrue(pharmacy.drugPricesLinkEnabled());
    }

    @Test(groups = "gotoLinkCheck")
    void testGoToDrugPrices() {
        pharmacy.clickDrugPrices();
        String expected = "Costco Membership Prescription Program - Rx Discount Card";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(driver.getTitle(), expected);
    }

    @Test(groups = "enabledCheck")
    void testGetPricesEnabled() {
        pharmacy.clickDrugPrices();
        assertTrue(pharmacy.getPricesEnabled(driver));
    }

    @Test(groups = "enabledCheck")
    void testSearchPricesEnabled() {
        pharmacy.clickDrugPrices();
        assertTrue(pharmacy.searchPricesEnabled(driver));
    }

    @Test(groups = "displayCheck")
    void testCarouselDisplay() {
        assertTrue(pharmacy.carouselDisplayed());
    }

    @Test(groups = "gotoLinkCheck")
    void testGoToRefillPage() {
        pharmacy.clickRefill();
        assertTrue(pharmacy.costcoLogoDisplayed(driver));
    }

    @Test(groups = "enabledCheck")
    void testAppStoreButtonEnabled() {
        pharmacy.clickRefill();
        assertTrue(pharmacy.appStoreButtonEnabled(driver));
    }

    @Test(groups = "enabledCheck")
    void testPlayStoreButtonEnabled() {
        pharmacy.clickRefill();
        assertTrue(pharmacy.playStoreButtonEnabled(driver));
    }

    @Test(groups = {"gotoLinkCheck", "displayCheck"})
    void testGotoWarehouseLocatorPage() {
        pharmacy.clickWarehouseLocator();
        assertTrue(pharmacy.costcoLogoDisplayed(driver));
    }

    @Test(groups = "enabledCheck")
    void testWarehouseSearchEnabled() {
        pharmacy.clickWarehouseLocator();
        assertTrue(pharmacy.warehouseSearchEnabled(driver));
    }

    @Test(groups = "enabledCheck")
    void testWarehouseFindEnabled() {
        pharmacy.clickWarehouseLocator();
        assertTrue(pharmacy.warehouseFindButtonEnabled(driver));
    }

    @Test(groups = "enabledCheck")
    void testEmptySearchErrorText() {
        pharmacy.clickDrugPrices();
        pharmacy.emptySearch();
        String expected = "Online price quote for this medication not available currently";
        assertEquals(pharmacy.emptySearchText(), expected);
    }
}
