package com.trycloud.fatih.practice;

import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US1 extends TestBase {

    @Test
    public void loginValid(){
        driver.get(url);
        driver.findElement(By.id("user")).sendKeys(username1);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit-form")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://qa.trycloud.net/index.php/apps/dashboard/");
    }

    @Test
    public void loginInvalid(){
        driver.get(url);
        driver.findElement(By.id("user")).sendKeys(username1);
        driver.findElement(By.id("password")).sendKeys(password+"a");
        driver.findElement(By.id("submit-form")).click();


        String actualMessage = driver.findElement(By.className("wrongPasswordMsg")).getText();
        Assert.assertEquals(actualMessage,"Wrong username or password.");
    }
}
