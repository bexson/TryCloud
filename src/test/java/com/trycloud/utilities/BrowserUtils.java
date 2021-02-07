package com.trycloud.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    public static void sleep(long seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            System.out.println("Can't handle with Interrupted exception");
        }
    }

    public static void hoover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

}
