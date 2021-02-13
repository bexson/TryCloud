package com.trycloud.fatih.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user")
    public WebElement userNameBox;


    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "submit-form")
    public WebElement submitButton;

    @FindBy(className = "wrongPasswordMsg")
    public WebElement errorMessage;

    public void urlCheck(){
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "http://qa.trycloud.net/index.php/apps/dashboard/";
        Assert.assertEquals(actualUrl,expectedUrl);
    }


}