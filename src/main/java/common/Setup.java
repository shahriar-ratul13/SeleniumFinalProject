package common;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Set;

public class Setup {

    public static WebDriver driver;

    // Method for launching browser with url as parameter
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    // Close browser window
    public void closeBrowser() {
        driver.close();
    }

    // Close driver
    public void quitDriver() {
        driver.quit();
    }

    // Mouse over method
    public void mouseOver(WebDriver dr, WebElement el) {
        Actions actions = new Actions(dr);
        actions.moveToElement(el).perform();
    }

    // Open in a link in a new tab
    public  void openInNewTab(WebDriver dr, WebElement el) {
        Actions actions = new Actions(dr);
        actions.keyDown(Keys.LEFT_CONTROL).click(el).keyUp(Keys.LEFT_CONTROL).build().perform();
    }

    // Select item from dropdown
    public void selectIndex(WebElement el, int index) {
        Select select = new Select(el);
        select.selectByIndex(index);
    }

    // Get text from the currently selected option
    public String selectText(WebElement el) {
        Select select = new Select(el);
        return select.getFirstSelectedOption().getText();
    }

    public void switchWindow(WebDriver dr) {
        Set<String> windowHandles =  dr.getWindowHandles(); // gets a set of strings of the windows
        String parentWindow = dr.getWindowHandle(); // stores handle/id of parent window

        // iterates through the stored window handles like the parent and child
        for (String handles : windowHandles) {
            // when iteration reaches child handle, swaps to it
            if (!handles.equals(parentWindow)) {
                dr.switchTo().window(handles);
            }
        }
    }

    public void switchToParentWindow(WebDriver dr) {
        Set<String> windowHandles =  dr.getWindowHandles(); // gets a set of strings of the windows
        String parentWindow = dr.getWindowHandle(); // stores handle/id of parent window

        // iterates through the stored window handles like the parent and child
        for (String handles : windowHandles) {
            // when iteration reaches child handle, swaps to it
            if (!handles.equals(parentWindow)) {
                dr.switchTo().window(handles);
            }
        }
        dr.switchTo().window(parentWindow);
    }

    // Explicitly wait for clickable element
    public void explicitWaitClickable(WebDriver dr, WebElement el) {
        WebDriverWait wait = new WebDriverWait(dr, 30);
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    public void explicitWaitVisible(WebDriver dr, WebElement el) {
        WebDriverWait wait = new WebDriverWait(dr, 30);
        wait.until(ExpectedConditions.visibilityOf(el));
    }
}
