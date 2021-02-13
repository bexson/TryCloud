package com.trycloud.fatih.base;

import com.trycloud.fatih.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public abstract class TestBaseDBM {
    protected final String url = ConfigurationReader.getProperty("url");
    protected final String username1 = ConfigurationReader.getProperty("username1");
    protected final String username2= ConfigurationReader.getProperty("username2");
    protected final String username3 = ConfigurationReader.getProperty("username3");
    protected final String username4 = ConfigurationReader.getProperty("username4");
    protected final String password = ConfigurationReader.getProperty("password");



    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }

    public void logIn(){
        Driver.getDriver().get(url);
        LoginPage login = new LoginPage();
        login.userNameBox.sendKeys(username1);
        login.passwordBox.sendKeys(password);
        login.submitButton.click();
        String actualURL= Driver.getDriver().getCurrentUrl();
        String expectedURL = "http://qa.trycloud.net/index.php/apps/dashboard/";
        Assert.assertEquals(actualURL,expectedURL);
    }
}
