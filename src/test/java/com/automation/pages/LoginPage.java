package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@id='Catalog']//p[1]")
    WebElement loginTxt;

    @FindBy(xpath = "//input[@name='username']")
    WebElement loginWithUserId;
    @FindBy(xpath = "//input[@name='password']")
    WebElement loginWithPassword;
    @FindBy(xpath = "//input[@name='signon']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@id='MenuContent']/a[3]")
    WebElement myAccountTxt;

    public String isLoginPageDisplayed(){
        return loginTxt.getText();
    }

    public void doLogin(String useridKey, String passwordKey){
        loginWithUserId.clear();
        loginWithUserId.sendKeys(useridKey);
        loginWithPassword.clear();
        loginWithPassword.sendKeys(passwordKey);
    }

    public void doLoginForInvalid(String useridKey, String passwordKey){
        loginWithUserId.clear();
        loginWithUserId.sendKeys(useridKey);
        loginWithPassword.clear();
        loginWithPassword.sendKeys(passwordKey);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    @DataProvider(name = "negativeLoginData")
    public static Object[][] negativeData(){
        return new Object[][] {
                {"234567", "raj456"},
                {"879065", "raj567"}
        };
    }

    public String verifyUserIsLoggedIn(){
        return myAccountTxt.getText();
    }
}

