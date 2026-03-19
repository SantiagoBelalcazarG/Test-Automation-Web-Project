package com.globant.automation.pages;

import com.globant.automation.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(className = "title")
    private WebElement titleLogo;

    @FindBy(className = "complete-header")
    private WebElement checkoutCompleteHeader;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String checkoutCompletePage(){
        return getText(titleLogo);
    }

    public boolean isCheckoutCompleteDisplayed(){
        return isDisplayed(checkoutCompleteHeader);
    }

    public String CheckoutCompleteText(){
        return getText(checkoutCompleteHeader);
    }

}