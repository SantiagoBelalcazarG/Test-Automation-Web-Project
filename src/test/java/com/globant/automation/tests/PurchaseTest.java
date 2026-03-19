package com.globant.automation.tests;

import com.globant.automation.pages.*;
import com.globant.automation.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setup(){
        loginPage = new LoginPage(driver);

        inventoryPage = loginPage.login(username, password);
    }

    @Test (testName = "Validate purchase flow for products")
    public void purchaseFlowTest(){
        Assert.assertEquals(inventoryPage.inventoryPage(), "Products");

        inventoryPage.addRandomProductToCart();

        CartPage cartPage = inventoryPage.goCart();

        Assert.assertEquals(cartPage.cartPage(), "Your Cart");

        CheckoutDataPage dataPage = cartPage.checkout();

        Assert.assertEquals(dataPage.checkoutDataPage(), "Checkout: Your Information");

        CheckoutOverviewPage overviewPage = dataPage.continueCheckoutOverview("Santiago", "Belalcazar", "12345");

        Assert.assertEquals(overviewPage.checkoutOverviewPage(), "Checkout: Overview");

        CheckoutCompletePage completePage = overviewPage.continueCheckoutComplete();

        Assert.assertEquals(completePage.checkoutCompletePage(), "Checkout: Complete!");
        Assert.assertTrue(completePage.isCheckoutCompleteDisplayed());
        Assert.assertEquals(completePage.CheckoutCompleteText(), "Thank you for your order!");
    }

}