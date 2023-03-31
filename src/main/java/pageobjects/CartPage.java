package pageobjects;

import common.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Setup {

    @FindBy(css = "div[class='flex-child'] span:nth-of-type(2) input:nth-of-type(2)")
    WebElement searchBar;

    @FindBy(xpath = "//button[@aria-label='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@id='navpills-sizing']/a[6]")
    WebElement petSuppliesLink;

    @FindBy(xpath = "//button[@id='add-0']/i")
    WebElement addQuantityButton;

    @FindBy(xpath = "//button[@id='addbutton-0']")
    WebElement addToCartFromSearch;

    @FindBy(xpath = "//div[@id='item-in-cart-0']")
    WebElement itemInCartText;

    @FindBy(css = "[automation-id='addToCartButton']")
    WebElement addToCartFromItemPage;

    @FindBy(xpath = "//a[@id='cart-d']")
    WebElement cartButton;

    @FindBy(css = "[automation-id=removeItemLink_1]")
    WebElement removeItemButton;

    @FindBy(xpath = "//a[@id='cart-d']/div/div/span")
    public WebElement cartAmountIcon;

    @FindBy(css = "[automation-id='productImageLink_0']")
    WebElement firstSearchItem;

    @FindBy(css = "[automation-id='viewCartButton']")
    WebElement viewCartButton;

    @FindBy(css = "[automation-id='continueShoppingButton']")
    WebElement continueShoppingButton;

    @FindBy(css = "[automation-id='shopCartCheckoutButton']")
    WebElement cartCheckoutButton;

    public void searchCostco(String input) {
        searchBar.sendKeys(input);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean searchItemDisplayed(WebDriver dr) {
        explicitWaitVisible(dr, firstSearchItem);
        return firstSearchItem.isDisplayed();
    }

    public void clickQuantityButton(WebDriver dr) {
        explicitWaitClickable(dr, addQuantityButton);
        addQuantityButton.click();
    }

    public void clickAddToCartSearch(WebDriver dr) {
        explicitWaitClickable(dr, addToCartFromSearch);
        addToCartFromSearch.click();
    }

    public boolean itemInCartDisplayed(WebDriver dr) {
        explicitWaitVisible(dr, itemInCartText);
        return  itemInCartText.isDisplayed();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public boolean removeItemDisplayed(WebDriver dr) {
        explicitWaitVisible(dr, removeItemButton);
        return removeItemButton.isDisplayed();
    }

    public boolean cartAmountIconDisplayed(WebDriver dr) {
        explicitWaitVisible(dr, cartAmountIcon);
        return cartAmountIcon.isDisplayed();
    }

    public void clickFirstSearchItem(WebDriver dr) {
        explicitWaitClickable(dr, firstSearchItem);
        firstSearchItem.click();
    }

    public boolean addToCartItemPageDisplayed(WebDriver dr) {
        explicitWaitClickable(dr, addToCartFromItemPage);
        return addToCartFromItemPage.isDisplayed();
    }

    public void clickAddToCartItemPage(WebDriver dr) {
        explicitWaitClickable(dr, addToCartFromItemPage);
        addToCartFromItemPage.click();
    }

    public boolean viewCartDisplayed(WebDriver dr) {
        explicitWaitClickable(dr, viewCartButton);
        return viewCartButton.isDisplayed();
    }

    public boolean continueShoppingDisplayed(WebDriver dr) {
        explicitWaitClickable(dr, continueShoppingButton);
        return continueShoppingButton.isDisplayed();
    }

    public void clickViewCart(WebDriver dr) {
        explicitWaitClickable(dr, viewCartButton);
        viewCartButton.click();
    }

    public boolean cartCheckoutButtonDisplayed (WebDriver dr) {
        explicitWaitClickable(dr, cartCheckoutButton);
        return cartCheckoutButton.isDisplayed();
    }
}
