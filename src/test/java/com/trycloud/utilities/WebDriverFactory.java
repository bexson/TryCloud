package com.trycloud.utilities;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    //Chrome
    public static WebDriver getDriver(String browserType){
        if (browserType.equalsIgnoreCase(ConfigurationReader.getProperty("browser"))){
            WebDriverManager.chromedriver().setup();

            return new ChromeDriver();
        }else if ((browserType.equalsIgnoreCase("firefox"))){
            WebDriverManager.firefoxdriver().setup();

            return new FirefoxDriver();
        }else{
            System.out.println("Given browser type does not exist. Driver = null!");
            return null;
        }
    }

    public static void manageWebDriver(WebDriver driver){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static void sleep(long seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            System.out.println("Can't handle with Interrupted exception");
        }
    }

    public static void findElementXpath(String stringXpath, WebDriver driver){
        driver.findElement(By.xpath(stringXpath));
    }

}
