package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage extends BasePage{

    @FindBy(xpath = "//div[@id='Catalog']/a")
    WebElement registerOption;
    @FindBy(xpath = "//div[@id='Catalog']//h3[1]")
    WebElement userInfoText;

    @FindBy(xpath = "//input[@name='username']")
    WebElement userId;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//input[@name='repeatedPassword']")
    WebElement repeatPassword;

    @FindBy(xpath = "//input[@name='account.firstName']")
    WebElement firstname;
    @FindBy(xpath = "//input[@name='account.lastName']")
    WebElement lastname;
    @FindBy(xpath = "//input[@name='account.email']")
    WebElement email;
    @FindBy(xpath = "//input[@name='account.phone']")
    WebElement phoneNo;
    @FindBy(xpath = "//input[@name='account.address1']")
    WebElement address1;
    @FindBy(xpath = "//input[@name='account.address2']")
    WebElement address2;
    @FindBy(xpath = "//input[@name='account.city']")
    WebElement city;
    @FindBy(xpath = "//input[@name='account.state']")
    WebElement state;
    @FindBy(xpath = "//input[@name='account.zip']")
    WebElement zip;
    @FindBy(xpath = "//input[@name='account.country']")
    WebElement country;
    @FindBy(xpath = "//input[@name='newAccount']")
    WebElement saveInformation;

    public void clickOnRegisterNow(){
        registerOption.click();
    }

    public String isRegisterPageDisplayed(){
        return userInfoText.getText();
    }

    public void fillRegisterInformation(){
        userId.sendKeys(ConfigReader.getConfigValue("userid"));
        password.sendKeys(ConfigReader.getConfigValue("password"));
        repeatPassword.sendKeys(ConfigReader.getConfigValue("password"));
        firstname.sendKeys(ConfigReader.getConfigValue("firstname"));
        lastname.sendKeys(ConfigReader.getConfigValue("lastname"));
        email.sendKeys(ConfigReader.getConfigValue("email"));
        phoneNo.sendKeys(ConfigReader.getConfigValue("phone"));
        address1.sendKeys(ConfigReader.getConfigValue("address1"));
        address2.sendKeys(ConfigReader.getConfigValue("address2"));
        city.sendKeys(ConfigReader.getConfigValue("city"));
        state.sendKeys(ConfigReader.getConfigValue("state"));
        zip.sendKeys(ConfigReader.getConfigValue("zip"));
        country.sendKeys(ConfigReader.getConfigValue("country"));
    }

    public void clickOnSave(){
        saveInformation.click();
    }

}
