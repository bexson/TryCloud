package com.trycloud.fatih.practice;

import com.trycloud.tests.base.TestBaseBM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US7 extends TestBaseBM {


    @BeforeMethod
    public void loginValid(){
        driver.get("http://qa3.trycloud.net");
        driver.findElement(By.id("user")).sendKeys(username1);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit-form")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://qa3.trycloud.net/index.php/apps/dashboard/");
    }

    @Test
    public void tC1searchAnyFile(){
        //Click search button
        driver.findElement(By.xpath("//a[@class='header-menu__trigger']")).click();
        //Type a text to search
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys();
    }
}
