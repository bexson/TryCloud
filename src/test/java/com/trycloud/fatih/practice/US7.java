package com.trycloud.fatih.practice;

import com.trycloud.fatih.utilities.U;
import com.trycloud.tests.base.TestBaseBM;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US7 extends TestBaseBM {
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

    @Test (invocationCount = 5)
    public void tC1searchAnyFile(){
        //Click search button
        driver.findElement(By.xpath("//a[@class='header-menu__trigger']")).click();
        String fileName = "hiya";
        String contactName = "Louetta Wiza";

        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));

        //Check if a file can be found
        searchBox.sendKeys(fileName);
        U.representation(represent,time);
        checkFileInResults(fileName);
        U.representation(represent,time);
        WebDriverFactory.sleep(1);
        //Clear searchbox
        searchBox.clear();

        U.representation(represent,time);


        //Check if a contact can be found
        searchBox.sendKeys(contactName);
        U.representation(represent,time);
        checkContactInResults(contactName);
        U.representation(represent,time);

        searchBox.clear();
    }


    //TODO: Add more check logic for different kinds such as folders

    public void checkFileInResults(String fileName){
        WebElement file = driver.findElement(By.xpath("//ul[@aria-label='Files']//h3[@title='"+fileName+"']"));
        Assert.assertTrue(file.isDisplayed(),"Something went wrong with file results check");
    }

    public void checkContactInResults(String contactName){
        WebElement contact = driver.findElement(By.xpath("//ul[@aria-label='Contacts']//h3[@title='"+contactName+"']"));
        Assert.assertTrue(contact.isDisplayed(), "Something went wrong with contact result check");
    }
}
