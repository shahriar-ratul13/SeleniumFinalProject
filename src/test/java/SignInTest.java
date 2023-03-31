import common.Setup;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.SignInPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
// 8 test
public class SignInTest extends Setup {

    SignInPage sign;

    @BeforeMethod // Open a new browser window for each test
    void initializeTest() {
        // Open the page for testing
        openBrowser("https://www.costco.com/LogonForm");
        // Initialize the web elements from the class as objects
        sign = PageFactory.initElements(driver, SignInPage.class);
        // Implicitly wait 10s
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod // Close all browser windows
    void exitBrowser() {
        closeBrowser();
    }

    @AfterTest // Close all driver instances after tests are completed
    void exitDriver() {
        quitDriver();
    }

    @Test
    void testEmailFieldEnabled() {
        assertTrue(sign.emailFieldEnabled());
    }

    @Test (priority = 1)
    void testPasswordFieldEnabled() {
        assertTrue(sign.passwordFieldEnabled());
    }

    @Test (priority = 2)
    void testCreateAccountButtonEnabled() {
        assertTrue(sign.createAccountButtonEnabled());
    }

    @Test (priority = 3) // Succeeds in sending the information and test passes, but the page does not load further
    void testCorrectSignIn() {
        sign.login("srcostcotesting@mailinator.com", "testingCostco@23");
    }

    @Test (priority = 4) // Test for valid email input
    void testInvalidEmail() {
        sign.login("asdasd", "testingCostco@23");
        String expectedError = "Enter a valid email address.";
        String actualError = sign.invalidEmailErrorText();
        assertEquals(actualError, expectedError);
    }

    @Test (priority = 4)  // Test with empty email field
    void testEmptyEmailField() {
        sign.loginEmptyEmail("testingCostco@23");
        String expectedError = "Email address is required.";
        String actualError = sign.emailRequiredErrorText();
        assertEquals(actualError, expectedError);
    }

    @Test (priority = 4)  // Test with empty password field
    void testEmptyPasswordField() {
        sign.loginEmptyPassword("srcostcotesting@mailinator.com");
        String expectedError = "Password is required.";
        String actualError = sign.passwordRequiredErrorText();
        assertEquals(actualError, expectedError);
    }

    @Test (priority = 5)
    void testGoToCreateAccount() {
        sign.openCreateAccountPage();
        explicitWaitVisible(driver, sign.createAccountHeader);
        assertEquals(sign.createAccountText(), "Create Account" );
    }
}
