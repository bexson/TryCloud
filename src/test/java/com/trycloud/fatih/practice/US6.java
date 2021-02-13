package com.trycloud.fatih.practice;

import com.trycloud.fatih.utilities.U;
import com.trycloud.tests.base.TestBaseBM;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US6 extends TestBaseBM {
    private String noteModuleXpath = "//a[@aria-label='Talk']";
    private boolean represent = false;
    private int time = 3;

    @BeforeMethod
    public void loginValid(){
        driver.get("http://qa3.trycloud.net");
        driver.findElement(By.id("user")).sendKeys(username1);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit-form")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://qa3.trycloud.net/index.php/apps/dashboard/");
    }


    @Test
    public void tC1accessTalks(){
        driver.findElement(By.xpath(noteModuleXpath)).click();
        U.representation(represent,time);
        Assert.assertTrue(driver.getTitle().contains("Talk"));
    }

    @Test
    public void tC2sendNotes(){
        driver.findElement(By.xpath(noteModuleXpath)).click();
        WebDriverFactory.sleep(100);

    }
}
