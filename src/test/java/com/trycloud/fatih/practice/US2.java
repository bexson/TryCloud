package com.trycloud.fatih.practice;

import com.trycloud.tests.base.TestBaseBC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US2 extends TestBaseBC {


    @Test
    public void loginValid(){
        driver.get(url);
        driver.findElement(By.id("user")).sendKeys(username1);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit-form")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://qa.trycloud.net/index.php/apps/dashboard/");
    }




    @Test
    public void mainModules(){
        List<WebElement> modules  = driver.findElements(By.xpath("//ul[@id='appmenu']/li/a/span"));
        List<String> expectedModules = new ArrayList<>(Arrays.asList("Files","Photos","Activity","Talk","Contacts","Calendar"));
        List<String> actualModules = new ArrayList<>();
        for(WebElement element : modules){
            actualModules.add(element.getAttribute("innerText"));
        }
        System.out.println(actualModules);
        System.out.println(expectedModules);
        Assert.assertTrue(actualModules.containsAll(expectedModules));



    }

}
