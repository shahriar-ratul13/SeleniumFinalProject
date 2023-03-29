package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Setup {

    public static WebDriver driver;

    // Method for launching browser with url as parameter
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    // Close browser windows after test
    public void quitBrowser() {
        driver.quit();
    }

    // Mouse over method
    public void mouseOver(WebDriver dr, WebElement el) {
        Actions actions = new Actions(dr);
        actions.moveToElement(el).perform();
    }

    // Explicitly wait for clickable element
    public void explicitWait(WebDriver drE, WebElement elE) {
        WebDriverWait wait = new WebDriverWait(drE, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elE));
    }

}
