package scenarios;

import TestComponents.BaseTest;
import ReportComponents.TestNGListener;
import TestComponents.ConfigReader;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static TestComponents.DriverSetup.driver;
import static org.testng.Assert.*;

@Listeners(TestNGListener.class)
@Epic("E2E Web Test")
public class VatanBilgisayarWebTest extends BaseTest {

    @Test(priority = 1)
    @Description("This test verifies the url of the website.")
    void verifyUrl() {
        assertEquals(driver.getCurrentUrl(), "https://www.vatanbilgisayar.com/");
    }

    @Test(priority = 2)
    @Description("Login Test with correct e-mail and password.")
    void verifySuccessfulLogin() {
        account.goToLoginPage();
        account.login(ConfigReader.properties.getProperty("email"),ConfigReader.properties.getProperty("password"));
        assertEquals(account.accountText().toLowerCase(), "Hesabım".toLowerCase());
    }

    @Test(dependsOnMethods = "verifySuccessfulLogin")
    @Description("This test verifies the results consists with correct product name.")
    void verifySuccessfulProductSearch() {
        search.searchProduct(ConfigReader.properties.getProperty("product"));
        assertTrue(search.getResultText().toLowerCase().contains(ConfigReader.properties.getProperty("product").toLowerCase()));
    }

    @Test(dependsOnMethods = "verifySuccessfulProductSearch")
    @Description("This test verifies payment page displays the correct price.")
    void verifyProductPrice() {
        product.selectProduct();
        product.goToCart();
        address.newAddress();
        payment.selectCargo();
        payment.goToPaymentPage();
        payment.getTotalPrice();
        assertEquals(payment.pricePart1, product.price);
    }

    @Test(dependsOnMethods = "verifyProductPrice")
    @Description("This test verifies successful logout.")
    void verifySuccessfulLogout() {
        payment.goToMainPage();
        account.logout();
        assertEquals(account.accountText().toLowerCase(), "giriş yap".toLowerCase());
    }

}

