package StepDefinitions;

import Utility.readconfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class loginPageStepDefination {
    private WebDriver driver;
    private LoginPage loginPage;
    readconfig c = new readconfig();

    @Before
    public void setUp() throws MalformedURLException {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        MutableCapabilities sauceOpts = new MutableCapabilities();
//        sauceOpts.setCapability("build","selenium-build-1ERRR");
//        sauceOpts.setCapability("seleniumVersion","latest");
//        sauceOpts.setCapability("username","oauth-srikerreddy.sheelam-44b32");
//        sauceOpts.setCapability("accessKey","454ee847-b051-4fc5-89dc-1bc655142f72");
//        sauceOpts.setCapability("tag","demo-chrome-tests");
//
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("sauce:options",sauceOpts);
//        cap.setCapability("browserVersion", "latest");
//        cap.setCapability("platformName","windows11");
//        cap.setCapability("browserName","chrome");
//
//        driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), cap);

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-srikerreddy.sheelam-44b32");
        sauceOptions.put("accessKey", "454ee847-b051-4fc5-89dc-1bc655142f72");
        sauceOptions.put("build", "selenium-build-1ERRR");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);
    }

    @After
    public void tearDown() {
        if (driver!=null){
            driver.quit();
        }
    }

    @Given("I am on the demo site login page")
    public void iAmOnTheLoginPage() {
        String url = readconfig.getProperty("url");
        driver.get(url);
        loginPage = new LoginPage(driver);
    }

    @Given("I have entered valid {string} and {string}")
    public void iHaveEnteredValidUserCredentials(String userName, String password) {
        loginPage.enterEmail(userName);
        loginPage.enterPassword(password);
    }

    @Given("I have entered invalid {string} and {string}")
    public void iHaveEnteredInvalidAndInvalidPassword(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void iClickOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see a success message indicating {string}")
    public void iShouldSeeSuccessMessageIndicating(String success_message) {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Account Services')]")).isDisplayed());
    }

    @Then("I should see an error message indicating {string}")
    public void iShouldSeeAnErrorMessageIndicating(String errorMessage) {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'The username and password could not be verified.')]")).isDisplayed());
    }

    @When("I click on Register link")
    public void iClickOnRegisterLink() {
        loginPage.clickRegisterButton();
    }

    @Then("I should be redirected to the user registration page")
    public void iShouldBeRedirectedToTheUserRegistrationPage() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Signing up is easy!')]")).isDisplayed());
    }
}
