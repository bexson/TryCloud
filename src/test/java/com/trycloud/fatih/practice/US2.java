package com.trycloud.fatih.practice;

import com.trycloud.fatih.pages.HomePage;
import com.trycloud.fatih.pages.LoginPage;
import com.trycloud.fatih.base.TestBaseDBM;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US2 extends TestBaseDBM {


    @Test
    public void loginValid(){
        Driver.getDriver().get(url);

        LoginPage login = new LoginPage();

        login.userNameBox.sendKeys(username1);
        login.passwordBox.sendKeys(password);
        login.submitButton.click();

        String actualURL= Driver.getDriver().getCurrentUrl();
        String expectedURL = "http://qa.trycloud.net/index.php/apps/dashboard/";
        Assert.assertEquals(actualURL,expectedURL);
    }




    @Test
    public void mainModules(){
        logIn();

        HomePage homePage = new HomePage();


        List<String> expectedModules = new ArrayList<>(Arrays.asList("Files","Photos","Activity","Talk","Contacts","Calendar"));
        List<String> actualModules = new ArrayList<>();
        for(WebElement element : homePage.moduleNames){
            actualModules.add(element.getAttribute("innerText"));
        }

        Assert.assertTrue(actualModules.containsAll(expectedModules));
    }

}
