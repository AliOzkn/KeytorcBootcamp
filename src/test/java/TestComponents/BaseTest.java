package TestComponents;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;

import static TestComponents.ConfigReader.properties;
import static TestComponents.DriverSetup.driver;


public class BaseTest {

    public Account account;
    public Search search;
    public Product product;
    public Address address;
    public Payment payment;

    @BeforeTest
    public void setUp() {
        properties = ConfigReader.initializeProperties();
        driver = DriverSetup.initializeDriver(properties.getProperty("browser"));
        driver.get(properties.getProperty("url"));
        account = new Account();
        search = new Search();
        product = new Product();
        address = new Address();
        payment = new Payment();
    }

    @AfterTest
    public void driverClose() {
        driver.quit();
    }

}
