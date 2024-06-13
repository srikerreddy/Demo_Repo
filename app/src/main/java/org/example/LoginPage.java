package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // By Locators
    private By emailInputLocator = By.xpath("//input[@name='username']");
    private By passwordInputLocator = By.xpath("//input[@name='password']");
    private By loginButtonLocator = By.xpath("//input[@class='button']");
    private By registerButtonLocator = By.xpath("//a[@href='register.htm']");

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void clickRegisterButton() {
        WebElement registerButton = driver.findElement(registerButtonLocator);
        registerButton.click();
    }
}
