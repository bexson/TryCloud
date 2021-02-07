package com.trycloud.fatih.practice;

import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US3 extends TestBase {


    @Test
    public void loginValid(){
        driver.get(url);
        driver.findElement(By.id("user")).sendKeys(username1);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit-form")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://qa.trycloud.net/index.php/apps/dashboard/");
    }

    @Test (dependsOnMethods = {"loginValid"})
    public void filesAccessTC1(){
        //Clicking the files module
        driver.findElement(By.xpath("//ul[@id='appmenu']/li[2]")).click();
        //Assigning title to a variable just to make things clear
        String title = driver.getTitle();
        //Checking if title contains files
        Assert.assertTrue(title.contains("Files"));
    }

    @Test (dependsOnMethods = {"filesAccessTC1"})
    public void selectAllUploadedFilesTC2(){
        //Clicking select all files checkbox
        driver.findElement(By.xpath("//th[@id='headerSelection']/label[@for='select_all_files']")).click();
        List<WebElement> filesSelectionBoxes = driver.findElements(By.xpath("//div[@id='app-content-files']//table[@id='filestable']/tbody/tr/td[1]/input"));
        System.out.println(filesSelectionBoxes.size());
        boolean flag = true;
        for(WebElement box : filesSelectionBoxes){
            if(!box.isSelected()){
                flag = false;
            }
        }
        Assert.assertTrue(flag);


    }


}
