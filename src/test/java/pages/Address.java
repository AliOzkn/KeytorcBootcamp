package pages;

import com.github.javafaker.Faker;
import PageComponents.Helper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static TestComponents.DriverSetup.driver;

public class Address extends Helper {
    Faker faker;
    Select slc;
    JavascriptExecutor js;
    By addressTitle = By.id("AddressRecordName");
    By nameAndSurname = By.id("NameandSurname");
    By phoneNumber = By.id("Gsm");
    By city = By.id("SelectedCityName");
    By county = By.id("FSelectedTownName");
    By address = By.id("Address");
    By IdNumber = By.id("Tckn");
    By saveBtn = By.cssSelector("button[type='submit']");

// ---------------------------------------------------------------------------------------------------------------------

    public void select(By elementName, String text) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        slc = new Select(driver.findElement(elementName));
        slc.selectByValue(text);
    }

    @Step("Create a new address with some personal information")
    public void newAddress() {

        faker = new Faker();
        sendKeys(addressTitle, faker.letterify("????"));
        sendKeys(nameAndSurname, faker.name().firstName() + " " + faker.name().lastName());
        sendKeys(phoneNumber, "5" + faker.numerify("#########"));

        select(city, "DENİZLİ");
        select(county, "PAMUKKALE");

        sendKeys(address, (faker.address().streetName() + " " + faker.address().buildingNumber()));
        //sendKeys(IdNumber,"2" + faker.numerify("##########"));
        sendKeys(IdNumber,"28798300478");

        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", find(saveBtn));
        click(saveBtn);


    }


}
