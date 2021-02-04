package com.trycloud.Viktoriya;

import com.trycloud.tests.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;


public class UserStory7 extends TestBase {
   /*   #7 As a user, I should be able to access search
any item/ users from the homepage*/

    public void login(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

}

