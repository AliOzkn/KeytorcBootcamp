package pages;

import PageComponents.Helper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Account extends Helper {

    By myAccountBtn = By.id("btnMyAccount");
    By loginBtnFromDropDownMenu = By.cssSelector("ul.login li:first-child");
    By email = By.id("email");
    By password = By.id("pass");
    By loginBtn = By.id("login-button");
    By AccountText = By.cssSelector("#btnMyAccount span[id]");
    By logoutBtnFromDropDownMenu = By.cssSelector(".account li:nth-of-type(6)");

// ---------------------------------------------------------------------------------------------------------------------

    @Step("Go to login page")
    public void goToLoginPage(){
        click(myAccountBtn);
        click(loginBtnFromDropDownMenu);
    }
    @Step("Login with username: {0}, password: {1}")
    public void login(String email,String password) {
        sendKeys(this.email,email);
        sendKeys(this.password, password);
        click(loginBtn);
    }
    @Step("Logout from account")
    public void logout() {
        click(myAccountBtn);
        click(logoutBtnFromDropDownMenu);
    }

    @Step("Get text of the element for validation")
    public String accountText() {
        return find(AccountText).getText();
    }

}
