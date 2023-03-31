package pageobjects;

import common.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MembershipPage extends Setup {



    @FindBy(css = "[data-bi-title='select gold star']")
    WebElement goldStarMembership;

    @FindBy(css = "[data-bi-title='select executive']")
    WebElement executiveMembership;

    @FindBy(xpath = "//div[@class='row no-gutter rs-costco-membership-membership-tabs']/div/div[2]/div/div/div/div/div[6]/div/button")
    WebElement purchaseMembership;

    // State drop down
    @FindBy(xpath = "//select[@id='state']")
    public WebElement stateDropdown;

    // Absolute XPath for header
    @FindBy(xpath = "/html/body/main/div[3]/div[1]/h1")
    public WebElement executiveHeaderText;

    @FindBy(xpath = "//div[@id='rs-costco-membership-wrapper-v3']/div[3]/div/a")
    WebElement renewMembership;

    @FindBy(xpath = "//div[@id='rs-costco-membership-wrapper-v3']/div[5]/div/div[1]/div/button[2]")
    WebElement switchBusinessMembership;

    @FindBy(xpath = "//div[@id='rs-costco-membership-wrapper-v3']/div[5]/div/div[1]/div/button[1]")
    WebElement switchPersonalMembership;

    @FindBy(css = "[data-bi-title='select business']")
    WebElement selectBusiness;

    @FindBy(css = "[data-bi-title='select business executive']")
    WebElement selectExecutiveBusiness;

    @FindBy(xpath = "//div[@id='rs-costco-membership-membership-tabs-business']/div[1]/div/div/div/div[1]/div/h2")
    WebElement businessHeader;

    @FindBy(css = "[data-bi-title='learn more-3']")
    WebElement learnMoreCiti;

    @FindBy(css = "[automation-id='confirmationButton']")
    WebElement externalLinkConfirmation;

    @FindBy(css = "[class='Hero_7__partner_link__application']")
    WebElement citiPageJoinLink;

    public void gotoGoldStarMembership() {
        goldStarMembership.click();
    }

    public void selectState() {
        selectIndex(stateDropdown, 3);
        selectText(stateDropdown);
    }

    public String selectStateText() {
        return selectText(stateDropdown);
    }

    public void gotoExecutiveMembership(WebDriver dr) {
        openInNewTab(dr, executiveMembership);
    }

    public boolean executiveTextDisplayed() {
        return executiveHeaderText.isDisplayed();
    }

    public boolean purchaseMembershipDisplayed() {
        return purchaseMembership.isDisplayed();
    }

    public boolean renewMembershipDisplayed(){
        return renewMembership.isDisplayed();
    }

    public void switchMembershipBusiness() {
        switchBusinessMembership.click();
    }

    public boolean businessDisplayed() {
        return selectBusiness.isDisplayed();
    }

    public boolean executiveBusinessDisplayed() {
        return selectExecutiveBusiness.isDisplayed();
    }

    public boolean businessHeaderDisplayed() {
        return businessHeader.isDisplayed();
    }

    public void learnMoreCitiClick() {
        learnMoreCiti.click();
    }

    public void clickExternalLink() {
        externalLinkConfirmation.click();
    }


    public boolean citiJoin() {
        return citiPageJoinLink.isDisplayed();
    }

}
