package com.trycloud.fatih.utilities;

import com.trycloud.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){
            String driverType = ConfigurationReader.getProperty("browser");

            switch (driverType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver =  new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver =  new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            }
        }
        return driver;
    }


    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            //TODO:  Check what happens if we dont assign driver to be null
            driver = null;
        }
    }
}
