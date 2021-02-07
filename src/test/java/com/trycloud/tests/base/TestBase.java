package com.trycloud.tests.base;

import com.github.javafaker.Faker;
import com.trycloud.Bektemir.pages.LoginPagePOM;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

    public abstract class TestBase {
        //This class created for re-usability of methods

        protected Faker faker = new Faker();

        //               Data for TryCloud WebSite :
        //It will take all data from configuration.properties using ConfigurationReader class
        protected final String url = ConfigurationReader.getProperty("url");
        protected final String username1 = ConfigurationReader.getProperty("username1");
        protected final String username2= ConfigurationReader.getProperty("username2");
        protected final String username3 = ConfigurationReader.getProperty("username3");
        protected final String username4 = ConfigurationReader.getProperty("username4");
        protected final String password = ConfigurationReader.getProperty("password");


        protected static WebDriver driver;

        @BeforeMethod // this will run 1 time only before class
        //setUp chrome driver
        public void setupClass(){
            driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
            assert driver != null; // it is just to get rid of warning
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

//        @AfterMethod // this will run 1 time only after class
        public void closeClass(){
            driver.close();
        }

        public void login(){
            LoginPagePOM loginPagePOM = new LoginPagePOM();
            loginPagePOM.login();
        }




}
