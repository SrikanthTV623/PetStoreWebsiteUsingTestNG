package com.automation.test;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    @Test(priority = 1)
    public void userRegistersToWebsite(){
        home.openWebsite();
        Assert.assertTrue(home.isHomePageDisplayed(), "Home page is not displayed");
        home.clicksOnSignIn();
        register.clickOnRegisterNow();
        Assert.assertEquals("User Information", register.isRegisterPageDisplayed());
        register.fillRegisterInformation();
        register.clickOnSave();
        Assert.assertTrue(home.isHomePageDisplayed(), "Home page is not displayed");
    }

    @Test(priority = 2)
    public void userLoginWithValidCredentials(){
        home.openWebsite();
        Assert.assertTrue(home.isHomePageDisplayed(), "Home page is not displayed");
        home.clicksOnSignIn();
        Assert.assertEquals("Please enter your username and password.",
                login.isLoginPageDisplayed());
        login.doLogin(ConfigReader.getConfigValue("userid"),
                ConfigReader.getConfigValue("password"));
        login.clickOnLoginButton();
        Assert.assertEquals("My Account", login.verifyUserIsLoggedIn());
        home.clicksOnSignOut();
    }

    @Test(dataProviderClass = LoginPage.class, dataProvider = "negativeLoginData",priority = 3)
    public void userLoginWithInValidCredentials(String userId, String pass){
        home.openWebsite();
        Assert.assertTrue(home.isHomePageDisplayed(), "Home page is not displayed");
        home.clicksOnSignIn();
        Assert.assertEquals("Please enter your username and password.",
                login.isLoginPageDisplayed());
        login.doLoginForInvalid(userId,pass);
        login.clickOnLoginButton();
        Assert.assertEquals("My Account", login.verifyUserIsLoggedIn());
        home.clicksOnSignOut();
    }

    @Test(priority = 4)
    public void userAddToCartAndDoCheckOut(){
        home.openWebsite();
        Assert.assertTrue(home.isHomePageDisplayed(), "Home page is not displayed");
        home.clicksOnSignIn();
        Assert.assertEquals("Please enter your username and password.",
                login.isLoginPageDisplayed());
        login.doLogin(ConfigReader.getConfigValue("userid"),
                ConfigReader.getConfigValue("password"));
        login.clickOnLoginButton();
        Assert.assertEquals("My Account", login.verifyUserIsLoggedIn());
        home.clickOnDogsOption();
        Assert.assertEquals("Dogs", dogs.isDogsPageDisplayed());
        dogs.selectBullDogItem();
        dogs.selectMaleBullDogAddToCart();
        Assert.assertEquals("Shopping Cart", dogs.isCartPageOpened());
        dogs.clickOnCheckOut();
        Assert.assertEquals("Payment Details", dogs.paymentOpened());
        dogs.clickOnPaymentAndOrderContinue();
        Assert.assertEquals("Thank you, your order has been submitted.", dogs.orderCompletion());
    }

}
