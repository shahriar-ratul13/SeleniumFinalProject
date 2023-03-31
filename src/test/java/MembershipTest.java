import common.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.MembershipPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

// 10 tests
public class MembershipTest extends Setup {

    MembershipPage membership;

    @BeforeMethod(alwaysRun = true)
        // Open a new browser window for each test
    void initializeTest() {
        // Open the page for testing
        openBrowser("https://www.costco.com/join-costco.html");
        // Initialize the web elements from the class as objects
        membership = PageFactory.initElements(driver, MembershipPage.class);
        // Implicitly wait 10s
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
        // Close all browser windows and driver instances after tests are completed, combined due to multiple windows
    void exitDriver() {
        closeBrowser();
        quitDriver();
    }

    @Test
    void testStateDropdown() {
        membership.gotoGoldStarMembership();
        membership.selectState();
        System.out.println(membership.selectStateText());
        assertEquals(membership.selectStateText(), "Alabama");
    }

    @Test
    void testDropDownElements() {
        membership.gotoGoldStarMembership();
        List<WebElement> options = driver.findElements(By.tagName("option"));

        for (WebElement option : options) {
            System.out.println("Options are:" + option.getText());
        }

        assertEquals(options.size(), 57);
    }

    @Test (groups = "gotoLinkCheck")
    void testOpeningExecutiveMembershipNewTab() {
        membership.gotoExecutiveMembership(driver);
        switchWindow(driver);
        String execText = membership.executiveHeaderText.getText();
        System.out.println(execText);
        assertTrue(membership.executiveTextDisplayed());
    }

    @Test(groups = {"gotoLinkCheck", "displayCheck"})
    void testReturningToJoinCostcoPage() {
        membership.gotoExecutiveMembership(driver);
        switchToParentWindow(driver);
        assertTrue(membership.renewMembershipDisplayed());
    }

    @Test(groups = "displayCheck")
    void testBusinessMembershipSwitch() {
        membership.switchMembershipBusiness();
        assertTrue(membership.businessHeaderDisplayed());
    }

    @Test(groups = "displayCheck")
    void testBusinessButton() {
        membership.switchMembershipBusiness();
        assertTrue(membership.businessDisplayed());
    }

    @Test(groups = "displayCheck")
    void testBusinessExecutiveButton() {
        membership.switchMembershipBusiness();
        assertTrue(membership.executiveBusinessDisplayed());
    }

    @Test(groups = "displayCheck")
    void testPurchaseMembershipButton() {
        assertTrue(membership.purchaseMembershipDisplayed());
    }

    @Test
    void testCitiLink() {
        membership.learnMoreCitiClick();
        membership.clickExternalLink();
    }

    @Test
    void testCitiPageLoaded() {
        membership.learnMoreCitiClick();
        membership.clickExternalLink();
        switchWindow(driver);
        assertTrue(membership.citiJoin());
    }
}
