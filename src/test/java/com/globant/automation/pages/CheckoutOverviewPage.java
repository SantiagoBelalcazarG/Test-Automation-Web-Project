package com.globant.automation.pages;

import com.globant.automation.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(className = "title")
    private WebElement titleLogo;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String checkoutOverviewPage(){
        return getText(titleLogo);
    }

    public CheckoutCompletePage continueCheckoutComplete(){
        click(finishButton);

        return new CheckoutCompletePage(driver);
    }

}