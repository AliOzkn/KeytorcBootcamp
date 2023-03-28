package PageComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static TestComponents.DriverSetup.driver;

public class Helper {
    public WebDriverWait wait;

    public Helper() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By elementName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementName)).click();
    }

    public void sendKeys(By elementName,String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementName)).sendKeys(text);
    }

    public WebElement find(By elementName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));
        return driver.findElement(elementName);
    }
    public List<WebElement> findAll(By elementName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));
        return driver.findElements(elementName);
    }

}

