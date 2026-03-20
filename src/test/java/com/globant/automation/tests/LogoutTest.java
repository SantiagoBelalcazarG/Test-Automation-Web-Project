package com.globant.automation.tests;

import com.globant.automation.pages.InventoryPage;
import com.globant.automation.pages.LoginPage;
import com.globant.automation.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setup(){
        loginPage = new LoginPage(driver);

        inventoryPage = loginPage.login(username, password);
    }

    @Test(testName = "Verify logout flow for users")
    public void logoutFlowTest(){
        Assert.assertEquals(inventoryPage.inventoryPage(), "Products");

        LoginPage returnedLoginPage = inventoryPage.logout();

        Assert.assertTrue(returnedLoginPage.isLoginDisplayed(), "User should be redirected to login page");
    }

}