package com.trycloud.Khrystyna;

import com.trycloud.Khrystyna.utilities.SensitiveData;
import com.trycloud.Khrystyna.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class userStory5 {

    /*5. Story: As a user, I should be able to access to Contacts module.
    Test case #1 - verify users can access to Talks module
1. Login as a user
2. Click “Contacts” module
3. Verify the page tile is Contents module’s tile
    Test case #2 - verify users can add contacts
1. Login as a user
2. Click contacts module
3. Click “New Contact” button
4. Fill out the contact info like : Title, Phone, email, address , etc
5. Verify the contact name is added to the contact list
     */

    WebDriver driver;
    SensitiveData sensitiveData;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://qa3.trycloud.net");
        SensitiveData sensitiveData = new SensitiveData();

    }

    @Test
    public void test_case_1(){
        //========================================================================================================//
        //                                      log in
        //locating logIn field
        WebElement loginField = driver.findElement(By.xpath("//input[@id='user']"));
        loginField.sendKeys(sensitiveData.getUserEmail());

        //locating password field
        WebElement passwordField = driver.findElement(By.cssSelector("input[id='password']"));
        passwordField.sendKeys(sensitiveData.getUserPassword());

        //locating logIn button
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();



    }





}
