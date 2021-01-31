package com.trycloud.Bektemir;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserStory3 extends TestBase {
    //As a user, I should be able to access to Files module.
    @BeforeClass
    public void getLoginPage(){
        driver.get(ConfigurationReader.getProperty("url"));
    }

    public void login(){
        WebElement userInp = driver.findElement(By.cssSelector("input[name='user']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("input[id='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[id='submit-form']"));

        userInp.sendKeys(ConfigurationReader.getProperty("username1"));//User17
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));//Userpass123
        loginButton.click();
    }

    @Test
    public void tc_1(){
        String actualTitle = driver.getTitle();
    }



}