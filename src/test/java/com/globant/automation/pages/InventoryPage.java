package com.globant.automation.pages;

import com.globant.automation.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class InventoryPage extends BasePage {

    @FindBy(className = "title")
    private WebElement titleLogo;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;

    @FindBys(@FindBy(css = "button.btn_inventory"))
    private List<WebElement> addToCartButtons;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String inventoryPage(){
        return getText(titleLogo);
    }

    public void addRandomProductToCart(){
        waitForAllVisible(addToCartButtons);

        int randomId = new Random().nextInt(addToCartButtons.size());

        click(addToCartButtons.get(randomId));
    }

    public CartPage goCart(){
        click(shoppingCartButton);

        return new CartPage(driver);
    }

}