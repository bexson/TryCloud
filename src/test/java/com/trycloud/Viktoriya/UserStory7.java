package com.trycloud.Viktoriya;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBaseBC;
import com.trycloud.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserStory7 extends TestBaseBC {
   /*   #7 As a user, I should be able to access search
any item/ users from the homepage*/
   WebDriver driver;
   Faker faker = new Faker();

   @BeforeClass
    public void login(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        WebDriverFactory.manageWebDriver(driver);
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");
        WebDriverFactory.sleep(1);

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
         //1. Login as a user (done)

    public void testCase(){
        WebDriverFactory.sleep(2);
        //2.Click magnifier icon 🔍 on the right top
        driver.findElement(By.xpath("/http/body/header/div[2]/div/a/span/svg")).click();

        //3.Search any existing file/folder/user name
        WebElement searchBox = driver.findElement(By.xpath("/http/body/header/div[2]/div[2]/div[2]/div[1]/form[1]/input"));
        WebDriverFactory.sleep(2);
        searchBox.click();
        searchBox.sendKeys("Talk");
        WebDriverFactory.sleep(2);
        driver.findElement(By.xpath("//*[@id=\"conversation_psgjabxg\"]/div[2]/div[1]/span[1]")).click();
        WebDriverFactory.sleep(2);

        //4.Verify the app displays the expected result option
    }



}

