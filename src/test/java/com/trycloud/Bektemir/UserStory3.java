package com.trycloud.Bektemir;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class UserStory3 extends TestBase {
    //As a user, I should be able to access to Files module.
    @BeforeMethod
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
        String actualTitle = driver.getTitle();
        String expectedTitle = "Files - Trycloud - QA";
        Assert.assertEquals(actualTitle,expectedTitle, "Titles didn't match, actual title: "+actualTitle+", and expected : "+expectedTitle);
    }

    public void pre_condition_for_TC2(){
        int n = 0 ;

       while (n<2) {
           driver.findElement(By.xpath("//span[@class='icon icon-add']")).click();
           WebDriverFactory.sleep(2);
           driver.findElement(By.xpath("//span[@class='icon icon-folder svg']")).click();//newFolderButton
           WebDriverFactory.sleep(2);
           driver.findElement(By.xpath("//input[@id='view13-input-folder']")).sendKeys(faker.educator().university());//inp box
           WebDriverFactory.sleep(2);
           driver.findElement(By.xpath("//input[@class='icon-confirm']")).click(); // createButton
           n++;
       }
    }


    @Test
    public void tc_1(){
        login();
    }


    }




