package com.globant.automation.pages;

import com.globant.automation.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(className = "login_logo")
    private WebElement loginLogo;

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginDisplayed(){
        return isDisplayed(loginLogo);
    }

    public InventoryPage login(String username, String password){
        write(usernameInput, username);
        write(passwordInput, password);

        click(loginButton);

        return new InventoryPage(driver);
    }

}