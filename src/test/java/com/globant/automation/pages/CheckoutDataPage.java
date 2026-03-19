package com.globant.automation.pages;

import com.globant.automation.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutDataPage extends BasePage {

    @FindBy(className = "title")
    private WebElement titleLogo;

    @FindBy(id = "first-name")
    private WebElement firstnameInput;

    @FindBy(id = "last-name")
    private WebElement lastnameInput;

    @FindBy(id = "postal-code")
    private WebElement postalcodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutDataPage(WebDriver driver) {
        super(driver);
    }

    public String checkoutDataPage(){
        return getText(titleLogo);
    }

    public CheckoutOverviewPage continueCheckoutOverview(String firstname, String lastname, String postalcode){
        write(firstnameInput, firstname);
        write(lastnameInput, lastname);
        write(postalcodeInput, postalcode);

        click(continueButton);

        return new CheckoutOverviewPage(driver);
    }

}