package pageobjects;

import common.Setup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Setup {

    @FindBy(xpath = "//input[@id='signInName']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@form='localAccountForm']")
    WebElement signInButton;

    @FindBy(id = "emailRequiredError")
    WebElement emailError; // Email address is required.

    @FindBy(id ="passwordRequiredError")
    WebElement passwordError; // Password is required.

    @FindBy(id = "invalidEmailError")
    WebElement invalidEmail; //Enter a valid email address.

    @FindBy(id = "createAccount")
    WebElement createAccountButton;

    @FindBy(id = "createAccountHeader")
    public WebElement createAccountHeader;

    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }

    public String invalidEmailErrorText() {
        return invalidEmail.getText();
    }

    public void loginEmptyEmail(String password) {
        passwordField.sendKeys(password);
        signInButton.click();
    }

    public void loginEmptyPassword(String email) {
        emailField.sendKeys(email);
        signInButton.click();
    }

    public String emailRequiredErrorText() {
        return emailError.getText();
    }

    public String passwordRequiredErrorText() {
        return passwordError.getText();
    }

    public void openCreateAccountPage() {
        createAccountButton.click();
    }

    public String createAccountText() {
        return createAccountHeader.getText();
    }

    public boolean emailFieldEnabled() {
        return emailField.isEnabled();
    }

    public boolean passwordFieldEnabled() {
        return passwordField.isEnabled();
    }

    public boolean createAccountButtonEnabled() {
        return createAccountButton.isEnabled();
    }
}
