package com.trycloud.Nikola;

import com.trycloud.Nikola.Utilities.Sensitive_Data;
import com.trycloud.Nikola.Utilities.Web_Driver_Factory;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory2 {

    WebDriver driver;
    Sensitive_Data sensitiveData;

    @BeforeClass
    public void DriverSetUp(){
        driver = Web_Driver_Factory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://qa3.trycloud.net/");
        sensitiveData = new Sensitive_Data();
    }

    @Test (priority = 1)
    public void LogIn () throws InterruptedException {
        //                  Locating Log In field
        WebElement LogInField = driver.findElement(By.xpath("//input[@type='text']"));
        LogInField.sendKeys(sensitiveData.getUserLogIn());

        //                  Locating the password
        WebElement PaswworField = driver.findElement(By.xpath("//input[@id='password']"));
        PaswworField.sendKeys(sensitiveData.getPassword());

        //                  Locating Log In button
        WebElement LogInButton = driver.findElement(By.cssSelector("input[id='submit-form']"));
        LogInButton.click();
        Thread.sleep(2000);

    }

    @Test (priority = 2)
    public void LocatingModules () throws InterruptedException {

        //                  Locating files
        WebElement FilesButton = driver.findElement(By.cssSelector("a[aria-label='Files']"));
        FilesButton.click();
        Thread.sleep(1000);

        // Verifying actual vs expected results
        String ExpectedResult_Files = "http://qa3.trycloud.net/index.php/apps/files/?dir=/&fileid=1232";
        String ActualResult_Files = driver.getCurrentUrl();

        // Comparing actual and expected result
        Assert.assertEquals(ExpectedResult_Files, ActualResult_Files,"Expected result is different from Actual result");
        Thread.sleep(2000);

        //==============================================================================================

        //                  Locating Photos

       WebElement PhotosButton = driver.findElement(By.cssSelector("a[aria-label='Photos']"));
       PhotosButton.click();
       Thread.sleep(1000);

        // Verifying actual vs expected results
        String ExpectedResult_Photos = "http://qa3.trycloud.net/index.php/apps/photos/";
        String ActualResult_Photos = driver.getCurrentUrl();

        // Comparing actual and expected result
        Assert.assertEquals(ExpectedResult_Photos, ActualResult_Photos,"Expected result is different from Actual result");
        Thread.sleep(2000);

        //===================================================================================================

        //                  Locating Activity
        WebElement ActivityButton = driver.findElement(By.cssSelector("a[aria-label='Activity']"));
        ActivityButton.click();
        Thread.sleep(1000);

        // Verifying actual vs expected results
        String ExpectedResult_Activity = "http://qa3.trycloud.net/index.php/apps/activity/";
        String ActualResult_Activity = driver.getCurrentUrl();

        // Comparing actual and expected result
        Assert.assertEquals(ExpectedResult_Activity, ActualResult_Activity,"Expected result is different from Actual result");
        Thread.sleep(2000);

        //=====================================================================================================

        //                  Locating Talk
        WebElement TalkButton = driver.findElement(By.cssSelector("a[aria-label='Talk']"));
        TalkButton.click();

        // Verifying actual vs expected results
        String ExpectedResult_Talk = "http://qa3.trycloud.net/index.php/apps/spreed/";
        String ActualResult_Talk = driver.getCurrentUrl();

        // Comparing actual and expected result
        Assert.assertEquals(ExpectedResult_Talk, ActualResult_Talk,"Expected result is different from Actual result");
        Thread.sleep(2000);

        //========================================================================================================

        //                  Locating Mail
        WebElement MailButton = driver.findElement(By.xpath("//a[@aria-label='Mail']"));
        MailButton.click();

        // Verifying actual vs expected results
        String ExpectedResult_Mail = "http://qa3.trycloud.net/index.php/apps/mail/setup";
        String ActualResult_Mail = driver.getCurrentUrl();

        // Comparing actual and expected result
        Assert.assertEquals(ExpectedResult_Mail, ActualResult_Mail,"Expected result is different from Actual result");
        Thread.sleep(2000);

        //==========================================================================================================

        //                 Locating Contacts
        WebElement ContactsButton = driver.findElement(By.xpath("//a[@aria-label='Contacts']"));
        ContactsButton.click();

        // Verifying actual vs expected results
        String ExpectedResult_Contacts = "http://qa3.trycloud.net/index.php/apps/contacts/All%20contacts";
        String ActualResult_Contacts = driver.getCurrentUrl();

        // Comparing actual and expected result
        Assert.assertEquals(ExpectedResult_Contacts, ActualResult_Contacts,"Expected result is different from Actual result");
        Thread.sleep(2000);

        //=============================================================================================================\

        //                  Locating Circles
        WebElement CirclesButton = driver.findElement(By.xpath("//a[@aria-label='Circles']"));
        CirclesButton.click();

        // Verifying actual vs expected results
        String ExpectedResult_Circles = "http://qa3.trycloud.net/index.php/apps/circles/";
        String ActualResult_Circles = driver.getCurrentUrl();

        // Comparing actual and expected result
        Assert.assertEquals(ExpectedResult_Circles, ActualResult_Circles,"Expected result is different from Actual result");
        Thread.sleep(2000);

        //=============================================================================================================

        //                  Locating Calendar
        WebElement CalendarButton = driver.findElement(By.xpath("//a[@aria-label='Calendar']"));
        CalendarButton.click();

        // Verifying actual vs expected results
        String ExpectedResult_Calendar = "http://qa3.trycloud.net/index.php/apps/calendar/dayGridMonth/now";
        String ActualResult_Calendar = driver.getCurrentUrl();

        // Comparing actual and expected result
        Assert.assertEquals(ExpectedResult_Calendar, ActualResult_Calendar,"Expected result is different from Actual result");
        Thread.sleep(2000);

        //=============================================================================================================

        //                  Locating Deck
        WebElement DeckButton = driver.findElement(By.xpath("//a[@aria-label='Deck']"));
        DeckButton.click();

        // Verifying actual vs expected results
        String ExpectedResult_Deck = "http://qa3.trycloud.net/index.php/apps/deck/#/";
        String ActualResult_Deck = driver.getCurrentUrl();

        // Comparing actual and expected result
        Assert.assertEquals(ExpectedResult_Deck, ActualResult_Deck,"Expected result is different from Actual result");
        Thread.sleep(2000);
    }

    @AfterClass
    public void TearDownClass () {
        driver.close();


    }
}
