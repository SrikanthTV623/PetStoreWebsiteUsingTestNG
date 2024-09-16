package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DogAddedPage extends BasePage {
    @FindBy(xpath = "//h2[text()='Dogs']")
    WebElement dogsTxt;

    @FindBy(xpath = "//a[text()='K9-BD-01']")
    WebElement bullDogItem;

    @FindBy(xpath = "//tbody/tr[2]/td[5]/a")
    WebElement addToCart;

    @FindBy(xpath = "//div[@id='Cart']/h2")
    WebElement cartTxt;

    @FindBy(xpath = "//div[@id='Cart']/a")
    WebElement checkOutButton;

    @FindBy(xpath = "//th[text()='Payment Details']")
    WebElement paymentTxt;

    @FindBy(xpath = "//input[@name='newOrder']")
    WebElement continueOnPayment;

    @FindBy(xpath = "//a[text()='Confirm']")
    WebElement continueOnOrder;

    @FindBy(xpath = "//ul[@class='messages']/li")
    WebElement orderCompletedTxt;

    public String isDogsPageDisplayed(){
        return dogsTxt.getText();
    }

    public void selectBullDogItem(){
        bullDogItem.click();
    }

    public void selectMaleBullDogAddToCart(){
        addToCart.click();
    }

    public String isCartPageOpened(){
        return  cartTxt.getText();
    }

    public void clickOnCheckOut(){
        checkOutButton.click();
    }

    public String paymentOpened(){
        return paymentTxt.getText();
    }

    public void clickOnPaymentAndOrderContinue(){
        continueOnPayment.click();
        continueOnOrder.click();
    }

    public String orderCompletion(){
        return orderCompletedTxt.getText();
    }

}
