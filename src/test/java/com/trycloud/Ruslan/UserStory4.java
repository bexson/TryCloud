package com.trycloud.Ruslan;

import com.github.javafaker.Faker;
import com.trycloud.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserStory4 {
    /*
    4. Story: As a user, I should be able to access to Talks module.

    Test case #1 - verify users can access to Talks module
    1. Login as a user
    2. Click Talks module
    3. Verify the page tile is Talks module’s tile

    Test case #2 - verify users can send message
    1. Login as a user
    2. Click Talks module
    3. Search a user from search box on the left
    4. Write a message
    5. Click submit button
    6. Verify the message is displayed on the conversation log
     */

    WebDriver driver;
    Faker faker = new Faker();

    @BeforeClass
    public void login(){
        //setup
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        WebDriverFactory.manageWebDriver(driver);
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");
        WebDriverFactory.sleep(1);

        //login
        WebDriverFactory.sleep(1);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("User17");
        WebDriverFactory.sleep(1);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Userpass123");
        WebDriverFactory.sleep(1);
        driver.findElement(By.xpath("//input[@id='submit-form']")).click();

        String expectedTitle = "Files - Trycloud - QA";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @AfterClass
    public void closeDriver(){
        WebDriverFactory.sleep(3);
        driver.quit();
    }

    @Test
    //1. Login as a user (did in login method)
    public void testCase1(){
        WebDriverFactory.sleep(2);
        //2. Click Talks module
        driver.findElement(By.xpath("/html/body/header/div[1]/ul/li[4]/a")).click();

        //3. Verify the page tile is Talks module’s tile
        String expectedTitle = "Talk - Trycloud - QA";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    //1. Login as a user (did in login method)
    public void testCase2(){

        //2. Click Talks module
        driver.findElement(By.xpath("/html/body/header/div[1]/ul/li[4]/a")).click();

        //3. Search a user from search box on the left
        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/form/input"));
        WebDriverFactory.sleep(2);
        searchBox.click();
        searchBox.sendKeys("Muhtar");
        WebDriverFactory.sleep(2);
        driver.findElement(By.xpath("//*[@id=\"conversation_psgjabxg\"]/div[2]/div[1]/span[1]")).click();
        WebDriverFactory.sleep(2);

        //4. Write a message
        String msg = faker.hobbit().character();
        driver.findElement(By.xpath("//div[@placeholder='Write message, @ to mention someone …']")).sendKeys(msg);
        WebDriverFactory.sleep(2);

        //5. Click submit button
        driver.findElement(By.xpath("//button[@aria-label='Send message']")).click();
        WebDriverFactory.sleep(2);

        //6. Verify the message is displayed on the conversation log
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='"+msg+"']")).isDisplayed(),"Test failed");
        WebDriverFactory.sleep(2);

    }





}



















