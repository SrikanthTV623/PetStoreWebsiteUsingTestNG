package com.automation.test;

import com.automation.pages.DogAddedPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.RegisterPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    HomePage home;
    RegisterPage register;
    LoginPage login;
    DogAddedPage dogs;

    @BeforeMethod
    public void setUp(){
        ConfigReader.initConfig();
        DriverManager.createDriver();
        home = new HomePage();
        register = new RegisterPage();
        login = new LoginPage();
        dogs = new DogAddedPage();
    }
    @AfterMethod
    public void cleanUp(){
        DriverManager.getDriver().quit();
    }
}
