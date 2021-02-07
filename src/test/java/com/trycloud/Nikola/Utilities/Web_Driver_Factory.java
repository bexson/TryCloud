package com.trycloud.Nikola.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Web_Driver_Factory {

    public static WebDriver getDriver (String browserType) {

        if(browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();

            return new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();

            return new FirefoxDriver();
        }else if(browserType.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();

            return new OperaDriver();
        }else if(browserType.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();

            return new EdgeDriver();
        }else {
            System.out.println("Giver browser type does not exist. Please enter a valid driver type. Driver = null");
            return null;
        }
    }

    }


