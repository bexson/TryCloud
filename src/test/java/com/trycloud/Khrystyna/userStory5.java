package com.trycloud.Khrystyna;

import com.trycloud.Khrystyna.utilities.SensitiveData;
import com.trycloud.Khrystyna.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class userStory5 {

    /*5. Story: As a user, I should be able to access to Contacts module.
    Test case #1 - verify users can access to Talks module
1. Login as a user
2. Click “Contacts” module
3. Verify the page tile is Contents module’s tile
    Test case #2 - verify users can add contacts
1. Login as a user
2. Click contacts module
3. Click “New Contact” button
4. Fill out the contact info like : Title, Phone, email, address , etc
5. Verify the contact name is added to the contact list
     */

    WebDriver driver;
    SensitiveData sensitiveData;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://qa3.trycloud.net");
        sensitiveData = new SensitiveData();

    }

    @Test
    public void test_case_1(){
        //========================================================================================================//
        //                                      log in
        //locating logIn field
        WebElement loginField = driver.findElement(By.xpath("//input[@id='user']"));
        loginField.sendKeys(sensitiveData.getUserEmail());

        //locating password field
        WebElement passwordField = driver.findElement(By.cssSelector("input[id='password']"));
        passwordField.sendKeys(sensitiveData.getUserPassword());

        //locating logIn button
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        WebDriverFactory.sleep(3);

        //----------------------------------------------------------------------------------------------------------//

        //locating CONTACTS MODULE
        WebElement ContactsButton = driver.findElement(By.xpath("//a[@aria-label='Contacts']"));
        ContactsButton.click();

        //getting and verifying page title
        String expectedTitle = "Contacts - Trycloud QA";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        WebDriverFactory.sleep(5);
        //-----------------------------------------------------------------------------------------------------------//
        //logOut
        //locating logOut button
        driver.findElement(By.xpath("//div[@id='expand']")).click();
        driver.findElement(By.xpath("//*[@id=\"expanddiv\"]/ul/li[4]/a")).click();
        WebDriverFactory.sleep(2);
        //============================================================================================================//

    }

    @Test
    public void test_case_2(){

        //========================================================================================================//
        //                                      log in
        //locating logIn field
        WebElement loginField = driver.findElement(By.xpath("//input[@id='user']"));
        loginField.sendKeys(sensitiveData.getUserEmail());

        //locating password field
        WebElement passwordField = driver.findElement(By.cssSelector("input[id='password']"));
        passwordField.sendKeys(sensitiveData.getUserPassword());

        //locating logIn button
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        //----------------------------------------------------------------------------------------------------------//

        //locating CONTACTS MODULE
        WebElement ContactsButton = driver.findElement(By.xpath("//a[@aria-label='Contacts']"));
        ContactsButton.click();
        WebDriverFactory.sleep(2);

        //locating +NEW CONTACT button
       WebElement NewContactButton = driver.findElement(By.xpath("//button[@class='icon-add']"));
       NewContactButton.click();
       WebDriverFactory.sleep(2);
       // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -//

       //locating NewContact field
        WebElement NewContactField = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        NewContactField.sendKeys("Michael Scott");
        WebDriverFactory.sleep(2);

       //locating Company Field
        WebElement CompanyField = driver.findElement(By.cssSelector("input[placeholder='Company']"));
        CompanyField.sendKeys("Dunder Mifflin");
        WebDriverFactory.sleep(2);

       //locating TitleField
        WebElement TitleField = driver.findElement(By.cssSelector("input[id='contact-title']"));
        TitleField.sendKeys("Branch Manager");
        WebDriverFactory.sleep(2);

       //locating PhoneNumber field
        WebElement PhoneNumberField = driver.findElement(By.xpath("//input[@inputmode='tel']"));
        PhoneNumberField.sendKeys("2677731164");
        WebDriverFactory.sleep(2);

        //locating Email field
        WebElement EmailField = driver.findElement(By.xpath("//input[@inputmode='email']"));
        EmailField.sendKeys("michaelscott@gmail.com");
        WebDriverFactory.sleep(2);

        //locating PostOfficeBox field
        WebElement POboxField = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[2]/input"));
        POboxField.sendKeys("23067S");
        WebDriverFactory.sleep(2);

        //locating Address field
       WebElement AddressField = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[3]/input"));
       AddressField.sendKeys("125 W Rodeo Ave");
        WebDriverFactory.sleep(2);

       //locating PostalCode field
        WebElement PostalCodeField = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[5]/input"));
        PostalCodeField.sendKeys("08269");
        WebDriverFactory.sleep(2);

        //locating City field
        WebElement CityField = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[6]/input"));
        CityField.sendKeys("Scranton");
        WebDriverFactory.sleep(2);

        //locating State field
        WebElement StateField = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[7]/input"));
        StateField.sendKeys("Pennsylvania");
        WebDriverFactory.sleep(2);

        //locating Country field
        WebElement CountryField = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[8]/input"));
        CountryField.sendKeys("USA");
        WebDriverFactory.sleep(2);

    }





}
