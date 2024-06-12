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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPageStepDefination {
    private WebDriver driver;
    private LoginPage loginPage;
    readconfig c = new readconfig();

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Login Successfully')]")).isDisplayed());
    }

    @Then("I should see an error message indicating {string}")
    public void iShouldSeeAnErrorMessageIndicating(String errorMessage) {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Enter your userName and password correct')]")).isDisplayed());
    }

    @When("I click on Register link")
    public void iClickOnRegisterLink() {
        loginPage.clickRegisterButton();
    }

    @Then("I should be redirected to the user registration page")
    public void iShouldBeRedirectedToTheUserRegistrationPage() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'To create your account')]")).isDisplayed());
    }
}
