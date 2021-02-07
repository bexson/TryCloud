package com.trycloud.tests.base;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

    public abstract class TestBaseBC {
        //This class created for re-usability of methods

        //               Data for TryCloud WebSite :
        //It will take all data from configuration.properties using ConfigurationReader class
        protected final String url = ConfigurationReader.getProperty("url");
        protected final String username1 = ConfigurationReader.getProperty("username1");
        protected final String username2= ConfigurationReader.getProperty("username2");
        protected final String username3 = ConfigurationReader.getProperty("username3");
        protected final String username4 = ConfigurationReader.getProperty("username4");
        protected final String password = ConfigurationReader.getProperty("password");


        protected static WebDriver driver;

        @BeforeClass // this will run 1 time only before class
        //setUp chrome driver
        public void setupClass(){
            driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
            assert driver != null; // it is just to get rid of warning
            WebDriverFactory.manageWebDriver(driver);
        }

        @AfterClass // this will run 1 time only after class
        public void closeClass(){
            driver.close();
        }





}
