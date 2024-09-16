package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@id='LogoContent']/a/img")
    WebElement logoImage;

    @FindBy(xpath = "//div[@id='MenuContent']/a[2]")
    WebElement signInButton;

    @FindBy(xpath = "//div[@id='MenuContent']/a[2]")
    WebElement signOutButton;

    @FindBy(xpath = "//div[@id='SidebarContent']/a[2]")
    WebElement dogsItem;



    public void openWebsite(){
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
    }
    public Boolean isHomePageDisplayed(){
        return logoImage.isDisplayed();
    }

    public void clicksOnSignIn(){
        signInButton.click();
    }
    public void clicksOnSignOut(){
        signOutButton.click();
    }

    public void clickOnDogsOption(){
        dogsItem.click();
    }
}
