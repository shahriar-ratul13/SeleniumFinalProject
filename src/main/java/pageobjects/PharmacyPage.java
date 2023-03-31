package pageobjects;

import common.Setup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PharmacyPage extends Setup {

    @FindBy(xpath = "//a[@id='refill-prescription-button']")
    WebElement refillButton;

    @FindBy(xpath = "//div[@id='rx-primary-actions']/div[2]/a")
    WebElement warehouseLocator;

    @FindBy(xpath = "//a[@id='logo']/img")
    WebElement costcoLogo;

    @FindBy(css = "[id='searchData']")
    WebElement warehouseSearch;

    @FindBy(css = "[id='submitbutton']")
    WebElement warehouseFindButton;

    @FindBy(xpath = "//div[@id='contentContainer']/footer/div[2]/div[1]/div[2]/ul/li[1]/a/img")
    WebElement appStoreButton;

    @FindBy(xpath = "//div[@id='contentContainer']/footer/div[2]/div[1]/div[2]/ul/li[2]/a/img")
    WebElement playStoreButton;

    @FindBy(css = "[id='hero-carousel']")
    WebElement carousel;

    @FindBy(xpath = "//main[@id='tiles-body-attribute']/div[4]/div/div[1]/a")
    WebElement drugPricesLink;

    @FindBy(css = "[id='cmppSubmitId']")
    WebElement getPricesButton;

    @FindBy(css = "[id='cmppDrugNameTextID']")
    WebElement searchPricesBar;

    @FindBy(xpath = "//div[@id='div_drugNameAutoSuggestionsError']/div")
    WebElement emptySearchError;


    public boolean refillButtonEnabled() {
        return refillButton.isEnabled();
    }

    public void clickRefill() {
        refillButton.click();
    }

    public boolean warehouseLocatorEnabled() {
        return warehouseLocator.isEnabled();
    }

    public void clickWarehouseLocator() {
        warehouseLocator.click();
    }

    public boolean costcoLogoDisplayed(WebDriver dr) {
        explicitWaitVisible(dr, costcoLogo);
        return costcoLogo.isDisplayed();
    }

    public boolean warehouseSearchEnabled(WebDriver dr) {
        explicitWaitClickable(dr, warehouseSearch);
        return warehouseSearch.isEnabled();
    }

    public boolean warehouseFindButtonEnabled(WebDriver dr) {
        explicitWaitClickable(dr, warehouseFindButton);
        return warehouseFindButton.isEnabled();
    }

    public boolean appStoreButtonEnabled(WebDriver dr) {
        explicitWaitClickable(dr, appStoreButton);
        return appStoreButton.isEnabled();
    }

    public boolean playStoreButtonEnabled(WebDriver dr) {
        explicitWaitClickable(dr, playStoreButton);
        return playStoreButton.isEnabled();
    }

    public boolean carouselDisplayed() {
        return carousel.isDisplayed();
    }

    public boolean drugPricesLinkEnabled() {
        return drugPricesLink.isEnabled();
    }

    public void clickDrugPrices() {
        drugPricesLink.click();
    }

    public boolean getPricesEnabled(WebDriver dr) {
        explicitWaitClickable(dr, getPricesButton);
        return getPricesButton.isEnabled();
    }

    public boolean searchPricesEnabled(WebDriver dr) {
        explicitWaitClickable(dr, searchPricesBar);
        return searchPricesBar.isEnabled();
    }

    public void emptySearch() {
        getPricesButton.click();
    }

    public String emptySearchText() {
        return emptySearchError.getText();
    }
}
