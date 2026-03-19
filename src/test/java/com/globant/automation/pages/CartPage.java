package com.globant.automation.pages;

import com.globant.automation.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    @FindBy(className = "title")
    private WebElement titleLogo;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String cartPage(){
        return getText(titleLogo);
    }

    public CheckoutDataPage checkout() {
        click(checkoutButton);

        return new CheckoutDataPage(driver);
    }

}