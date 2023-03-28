package pages;

import PageComponents.Helper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Product extends Helper {
    By sortOptions = By.id("sortOptionsDesktop");
    By cheapToExpensive = By.cssSelector("#sortOptionsDesktop option:nth-of-type(2)");
    By productList = By.cssSelector("#productsLoad div.product-list div.product-list__image-safe");
    By stockText = By.cssSelector(".wrapper-condition__text");
    By productPrice = By.cssSelector(".product-detail div.product-list__cost span.product-list__price");
    By addToCartBtn = By.cssSelector("button[id='add-to-cart-button']");
    By goToCartBtn = By.cssSelector(".goToBasket");
    By continueBtn = By.cssSelector(".continuebutton");
    public String price;

// ---------------------------------------------------------------------------------------------------------------------
    @Step ("Select the cheapest product")
    public void selectProduct() {
        click(sortOptions);
        click(cheapToExpensive);

        for (int i = 0; i < findAll(productList).size(); i++) {
            if (findAll(stockText).get(i).getText().equals("KARGO BEDAVA")) {
                findAll(productList).get(i).click();
                price = find(productPrice).getText();
                break;
            }
        }
        click(addToCartBtn);
    }
    @Step("Go to the cart page")
    public void goToCart(){
        click(goToCartBtn);
        click(continueBtn);
    }

}
