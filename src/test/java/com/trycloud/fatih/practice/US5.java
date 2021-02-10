package com.trycloud.fatih.practice;

import com.github.javafaker.Faker;
import com.trycloud.fatih.utilities.U;
import com.trycloud.tests.base.TestBaseBM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class US5 extends TestBaseBM {
    private String contactsModuleXpath = "//a[@aria-label='Contacts']";
    private boolean represent = true;
    private int time = 3;

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
        U.representation(represent,time);
        //Click new contact button
        driver.findElement(By.id("new-contact-button")).click();
        U.representation(represent,time);


        //Detect input boxes from the form and put fake values
        //Name
        WebElement name = driver.findElement(By.id("contact-fullname"));
        name.clear(); //clear default text from contact title
        name.sendKeys(contactName);
        U.representation(represent,time);
        //Phone
        WebElement phone = driver.findElement(By.xpath("//input[@inputmode='tel']"));
        phone.sendKeys(faker.phoneNumber().cellPhone());
        U.representation(represent,time);
        //Email
        WebElement email = driver.findElement(By.xpath("//input[@inputmode='email']"));
        email.sendKeys(faker.internet().emailAddress());
        U.representation(represent,time);
        //Post office box
        WebElement postOfficeBox = driver.findElement(By.xpath("//div[@prop-name='adr']/div[2]/input"));
        postOfficeBox.sendKeys(faker.number().numberBetween(10,100) + "");
        U.representation(represent,time);
        //Adress
        WebElement adress = driver.findElement(By.xpath("//div[@prop-name='adr']/div[3]/input"));
        adress.sendKeys(faker.address().streetAddress());
        U.representation(represent,time);
        //Extended adress
        WebElement extendedAdress = driver.findElement(By.xpath("//div[@prop-name='adr']/div[4]/input"));
        extendedAdress.sendKeys(faker.address().fullAddress());
        U.representation(represent,time);
        //Postalcode
        WebElement postalCode = driver.findElement(By.xpath("//div[@prop-name='adr']/div[5]/input"));
        postalCode.sendKeys(faker.address().zipCodeByState("NJ"));
        U.representation(represent,time);
        //City
        WebElement city = driver.findElement(By.xpath("//div[@prop-name='adr']/div[6]/input"));
        city.sendKeys(faker.address().cityName());
        U.representation(represent,time);
        //State
        WebElement stateOrProvince = driver.findElement(By.xpath("//div[@prop-name='adr']/div[7]/input"));
        stateOrProvince.sendKeys(faker.address().state());
        U.representation(represent,time);
        //Country
        WebElement country = driver.findElement(By.xpath("//div[@prop-name='adr']/div[8]/input"));
        country.sendKeys("USA");
        U.representation(represent,time);



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
        U.representation(represent,time);
        List<WebElement> contactList = driver.findElements(By.xpath("//div[@class='app-content-list-item-line-one']"));
        for(WebElement element : contactList){
            System.out.println(element.getText());
        }

    }














   
}
