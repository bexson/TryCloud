package com.trycloud.fatih.practice;

import com.trycloud.tests.base.TestBaseBM;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class US3 extends TestBaseBM {

    @BeforeMethod
    public void loginValid(){
        driver.get(url);
        driver.findElement(By.id("user")).sendKeys(username1);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit-form")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://qa.trycloud.net/index.php/apps/dashboard/");
    }

    @Test
    public void filesAccessTC1(){
        //Clicking the files module
        driver.findElement(By.xpath("//ul[@id='appmenu']/li[2]")).click();
        //Assigning title to a variable just to make things clear
        String title = driver.getTitle();
        //Checking if title contains files
        Assert.assertTrue(title.contains("Files"));
    }

    @Test
    public void selectAllUploadedFilesTC2(){
        //Clicking the files module
        driver.findElement(By.xpath("//ul[@id='appmenu']/li[2]")).click();
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

    @Test
    public void addFileTC3(){
        //Clicking the files module
        driver.findElement(By.xpath("//ul[@id='appmenu']/li[2]")).click();
        WebDriverFactory.sleep(30);

        //Getting all action-icon of all elements
        List<WebElement> files = driver.findElements(By.xpath("//table[@id='filestable']/tbody[@id='fileList']//a[@class='action action-menu permanent']"));
        //Getting name of all files
        List<WebElement> fileNames = driver.findElements(By.xpath("//div[@id='app-content-files']//table[@id='filestable']//span[@class='innernametext']"));
        //xpath to locate favorite add or remove favorite button just to make it for loop seem more clear
        String favoriteAddRemButtonXpath = "//a[@class='menuitem action action-favorite permanent']";
        //To store the name of the first file that is not added to favorites
        String fileOnFilesModule = "";
        for(int i =0; i<files.size();i++){
            //Checking all files when found one that is not added to favorite store its name
            files.get(i).click();
            if(driver.findElement(By.xpath(favoriteAddRemButtonXpath)).getText().equals("Add to favorites")){
                fileOnFilesModule = fileNames.get(i).getText();
                driver.findElement(By.xpath(favoriteAddRemButtonXpath)).click();
                break;
            }
            files.get(i).click();
        }
        //Click Favorites sub-Module
        driver.findElement(By.linkText("Favorites")).click();

        //All favorite file names
        List<WebElement> favoriteFiles = driver.findElements(By.xpath("//div[@id='app-content-favorites']//table[@id='filestable']/tbody//span[@class='innernametext']"));
        boolean flag = false;
        for(WebElement element : favoriteFiles){
            //Checking favorite file names if any of them matches with the one chosen at the first part of the code
            if(element.getText().equals(fileOnFilesModule)){
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);
    }


}
