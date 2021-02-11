package com.trycloud.fatih.practice;

import com.trycloud.fatih.pages.LoginPage;
import com.trycloud.utilities.Driver;
import com.trycloud.fatih.base.TestBaseDBM;
import com.trycloud.utilities.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US1 extends TestBaseDBM {

    @Test(priority = 1)
    public void loginValid(){

        Driver.getDriver().get(url);


        LoginPage login = new LoginPage();


        login.userNameBox.sendKeys(username1);

        login.passwordBox.sendKeys(password);

        login.submitButton.click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"http://qa.trycloud.net/index.php/apps/dashboard/");
    }

    @Test(priority = 2)
    public void loginInvalid(){

        LoginPage login = new LoginPage();

        login.userNameBox.sendKeys(username1);

        login.passwordBox.sendKeys(password+"a");

        login.submitButton.click();

        String actualMessage = login.errorMessage.getText();
        Assert.assertEquals(actualMessage,"Wrong username or password.");
    }

    @Test
    public void test(){
        WebDriverFactory.sleep(3);
    }
}
