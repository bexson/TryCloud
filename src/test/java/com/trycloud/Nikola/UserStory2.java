package com.trycloud.Nikola;

import com.trycloud.Nikola.Utilities.Sensitive_Data;
import com.trycloud.Nikola.Utilities.Web_Driver_Factory;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

        //Navigating driver to the home page
        driver.navigate().back();
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
        driver.navigate().back();
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
        driver.navigate().back();
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
        driver.navigate().back();
        Thread.sleep(2000);






    }


}
