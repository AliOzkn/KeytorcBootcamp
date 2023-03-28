package pages;

import PageComponents.Helper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class Search extends Helper {
    By searchBox = By.id("navbar-search-input");
    By searchBtn = By.cssSelector("button.search__button");
    By resultText = By.id("suggestionSearchİtem");

// ---------------------------------------------------------------------------------------------------------------------
    @Step("Search for this product: {0}")
    public void searchProduct(String product){
        sendKeys(searchBox,product);
        click(searchBtn);
    }

    @Step("Get text of the element for validation")
    public String getResultText(){
       return find(resultText).getText();
    }
}
