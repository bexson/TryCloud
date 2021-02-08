package com.trycloud.fatih.practice;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBaseBM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US4 extends TestBaseBM {
    private String talksModuleXpath = "//ul[@id='appmenu']/li[@data-id='spreed']/a";

    @BeforeMethod
    public void loginValid(){
        driver.get("http://qa3.trycloud.net");
        driver.findElement(By.id("user")).sendKeys(username1);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit-form")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://qa3.trycloud.net/index.php/apps/dashboard/");

    }

    @Test
    public void accessTalksTC1(){
        //Click talks module
        driver.findElement(By.xpath(talksModuleXpath)).click();
        Assert.assertTrue(driver.getTitle().contains("Talk"));
    }

    @Test
    public void sendMessageTC2(){
        Faker faker = new Faker();
        //Click talks module
        driver.findElement(By.xpath(talksModuleXpath)).click();

        //Find a user
        driver.findElement(By.xpath("//input[@class='app-navigation-search__input']")).sendKeys(username3);

        //Choose user from List
//        TODO: Arrange it so it can find the right one among multiple users
        driver.findElement(By.xpath("//span[@class='acli__content__line-one__title']/../../..")).click();

        //Find messageBox and submit button
        WebElement messageBox = driver.findElement(By.xpath("//div[@class = 'new-message-form__advancedinput']"));
        WebElement button = driver.findElement(By.xpath("//button[@aria-label='Send message']"));

        String message = faker.dragonBall().character();
        messageBox.sendKeys(message);
        button.click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[.='"+message+"']")).isDisplayed());

    }


}
