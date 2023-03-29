package pageobjects;

import common.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomePage extends Setup {

    // Search bar locator using CSS parent-child
    @FindBy(css = "div[class='flex-child'] span:nth-of-type(2) input:nth-of-type(2)")
    WebElement searchBar;

    //Search button locator using XPath
    @FindBy(xpath = "//button[@aria-label='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@id='navigation-dropdown']")
    WebElement shopMenu;

    // Shop links
    @FindBy(xpath = "//a[@id='navigation-dropdown']")
    Set<WebElement> shopLinks;

    // Grocery

    // List of items under Shop category

    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    @FindBy(xpath = "//button[@id='closeEmailPopup']/span")
    WebElement emailPopup;

    @FindBy(id = "Home_Ancillary_2")
    WebElement deals;

    // Method for typing words into search bar with string parameter
    public void searchCostco(String input) {
        searchBar.sendKeys(input);
    }

    // Method for initiating search
    public void clickSearchButton() {
        searchButton.click();
    }

    // Check if Shop is displayed
    public boolean shopDisplay(WebDriver dr) {
        mouseOver(dr, shopMenu);
        return shopMenu.isDisplayed();
    }

    // Get the link elements from Shop Menu
    public ArrayList<String> shopMenu() {
        ArrayList<String> links = new ArrayList<>();
        for (WebElement link: shopLinks) {
            links.add(link.getText());
        }
        return links;
    }

    // Get the total number of links on the page
    public int pageLinkAmount() {
        int linkNumber = allLinks.size();
        return linkNumber;
    }

    // Close popup after waiting for it
    public void closePopup(WebDriver drE) {
        explicitWait(drE, emailPopup);
        emailPopup.click();
    }
}
