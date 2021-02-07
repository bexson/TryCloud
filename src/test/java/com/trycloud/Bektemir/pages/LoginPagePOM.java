package com.trycloud.Bektemir.pages;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPagePOM {
    // Login Page Project Object Model (POM)
    @FindBy(xpath = "//input[@name='user']") //WebElement something = driver.findElement(By.Something) ;
    public WebElement inputUserName;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputPassword ;
    @FindBy(xpath= "//input[@type='submit']")
    public WebElement loginButton ;

    public void login(){
        inputUserName.sendKeys(ConfigurationReader.getProperty("username1"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }




}
