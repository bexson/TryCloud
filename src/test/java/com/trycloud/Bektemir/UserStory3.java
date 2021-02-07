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
    //TODO: As a user, I should be able to access to Files module.
    @BeforeMethod
    public void getLoginPage(){
        driver.get(ConfigurationReader.getProperty("url"));
    }




    @Test
    public void tc_1(){

    }

    }




