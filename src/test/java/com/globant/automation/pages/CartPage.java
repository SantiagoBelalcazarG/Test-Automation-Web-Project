package com.globant.automation.pages;

import com.globant.automation.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "title")
    private WebElement titleLogo;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(css = ".cart_button")
    private List<WebElement> removeFromCartButtons;

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String cartPage(){
        return getText(titleLogo);
    }

    public int cartItemsCount() {
        return cartItems.size();
    }

    public void removeProducts(){
        while (removeFromCartButtons.size() > 0){
            click(removeFromCartButtons.get(0));
        }
    }

    public boolean isCartEmpty(){
        return cartItems.size() == 0;
    }

    public CheckoutDataPage checkout() {
        click(checkoutButton);
        return new CheckoutDataPage(driver);
    }
}