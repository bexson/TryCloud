package com.trycloud.fatih.practice;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBaseBM;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class US5 extends TestBaseBM {
    private String contactsModuleXpath = "//a[@aria-label='Contacts']";
    private boolean represent = true;

    @BeforeMethod
    public void loginValid(){
        driver.get("http://qa3.trycloud.net");
        driver.findElement(By.id("user")).sendKeys(username1);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit-form")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://qa3.trycloud.net/index.php/apps/dashboard/");

    }

    @Test
    public void accessContactsTC1(){
        //Click talks module
        driver.findElement(By.xpath(contactsModuleXpath)).click();
        //Assert title
        Assert.assertTrue(driver.getTitle().contains("Contacts"));

    }

    @Test
    public void addContactTC2(){
        //TODO: Fill some other details of the  form
        Faker faker = new Faker();
        //It is declared here because it will be used to check if contact is added to list
        String contactName = faker.name().fullName();
        //Click talks module
        driver.findElement(By.xpath(contactsModuleXpath)).click();
        representation(represent);
        //Click new contact button
        driver.findElement(By.id("new-contact-button")).click();
        representation(represent);


        //Detect input boxes from the form and put fake values
        //Name
        WebElement name = driver.findElement(By.id("contact-fullname"));
        name.clear(); //clear default text from contact title
        name.sendKeys(contactName);
        representation(represent);
        //Phone
        WebElement phone = driver.findElement(By.xpath("//input[@inputmode='tel']"));
        phone.sendKeys(faker.phoneNumber().cellPhone());
        representation(represent);
        //Email
        WebElement email = driver.findElement(By.xpath("//input[@inputmode='email']"));
        email.sendKeys(faker.internet().emailAddress());
        representation(represent);
        //Post office box
        WebElement postOfficeBox = driver.findElement(By.xpath("//div[@prop-name='adr']/div[2]/input"));
        postOfficeBox.sendKeys(faker.number().numberBetween(10,100) + "");
        representation(represent);
        //Adress
        WebElement adress = driver.findElement(By.xpath("//div[@prop-name='adr']/div[3]/input"));
        adress.sendKeys(faker.address().streetAddress());
        representation(represent);
        //Extended adress
        WebElement extendedAdress = driver.findElement(By.xpath("//div[@prop-name='adr']/div[4]/input"));
        extendedAdress.sendKeys(faker.address().fullAddress());
        representation(represent);
        //Postalcode
        WebElement postalCode = driver.findElement(By.xpath("//div[@prop-name='adr']/div[5]/input"));
        postalCode.sendKeys(faker.address().zipCodeByState("NJ"));
        representation(represent);
        //City
        WebElement city = driver.findElement(By.xpath("//div[@prop-name='adr']/div[6]/input"));
        city.sendKeys(faker.address().cityName());
        representation(represent);
        //State
        WebElement stateOrProvince = driver.findElement(By.xpath("//div[@prop-name='adr']/div[7]/input"));
        stateOrProvince.sendKeys(faker.address().state());
        representation(represent);
        //Country
        WebElement country = driver.findElement(By.xpath("//div[@prop-name='adr']/div[8]/input"));
        country.sendKeys("USA");
        representation(represent);



        //Get all contact names
        List<WebElement> contactList = driver.findElements(By.xpath("//div[@class='app-content-list-item-line-one']"));
        boolean flag = false;
        //check if newly added contact is on the contact list
        for(WebElement element : contactList){
            System.out.println(element.getText());
            if(element.getText().equals(contactName)){
                flag = true;
            }
        }
        Assert.assertTrue(flag);
    }

    @Test
    public void allContactNamesTC3(){
        //TODO: Figure out what to assert in this test case
        driver.findElement(By.xpath(contactsModuleXpath)).click();
        representation(represent);
        List<WebElement> contactList = driver.findElements(By.xpath("//div[@class='app-content-list-item-line-one']"));
        for(WebElement element : contactList){
            System.out.println(element.getText());
        }

    }














    private void representation(boolean represent){
        if(represent) {
            WebDriverFactory.sleep(50);
        }
    }
}
