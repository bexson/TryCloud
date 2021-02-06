package com.trycloud.fatih.practice;

import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US2 extends TestBase {


    @Test
    public void loginValid(){
        driver.get(url);
        driver.findElement(By.id("user")).sendKeys(username1);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit-form")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://qa.trycloud.net/index.php/apps/files/?dir=/&fileid=3112");
    }

    @Test
    public void mainModules(){
        List<WebElement> modules  = driver.findElements(By.xpath("//ul[@id='appmenu']/li/a/span"));
        for(WebElement element : modules){
            System.out.println("element.getText() = " + element.getText());
        }
    }

}
