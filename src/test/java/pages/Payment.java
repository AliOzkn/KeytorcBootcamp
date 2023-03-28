package pages;

import PageComponents.Helper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static TestComponents.DriverSetup.driver;

public class Payment extends Helper{
    By cargo = By.xpath("//ul//div[@class='col-lg-6'][1]");
    By totalPrice = By.cssSelector(".basket-ordersummary__total .text-right");
    By confirmProduct = By.className("btn-success");
    By mainLogo = By.className("navbar-brand");

// ---------------------------------------------------------------------------------------------------------------------
    public String pricePart1;

    @Step ("Select a shipping company")
    public void selectCargo() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        click(cargo);

    }
    @Step ("Go to payment page")
    public void goToPaymentPage() {
        click(confirmProduct);
    }

    @Step("Get the price of the product on payment page")
    public void getTotalPrice() {
        String[] parts = find(totalPrice).getText().split(",");
        pricePart1 = parts[0];
    }

    @Step ("Go to main page for logout operation")
    public void goToMainPage() {
        click(mainLogo);
    }
}
