package com.trycloud.fatih.practice;

import com.github.javafaker.Faker;
import com.trycloud.fatih.base.TestBaseDBM;
import com.trycloud.fatih.pages.ContactsPage;
import com.trycloud.fatih.pages.HomePage;
import com.trycloud.fatih.pages.LoginPage;
import com.trycloud.fatih.utilities.U;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US5 extends TestBaseDBM {
    private String contactsModuleXpath = "//a[@aria-label='Contacts']";
    private boolean represent = false;
    private int time = 1;

    @BeforeMethod
    public void loginValid(){
        LoginPage loginPage = new LoginPage();

        Driver.getDriver().get(url);

        loginPage.userNameBox.sendKeys(username1);

        loginPage.passwordBox.sendKeys(password);

        loginPage.submitButton.click();

        loginPage.urlCheck();

    }

    @Test
    public void accessContactsTC1(){
        HomePage homePage = new HomePage();

        homePage.contactsModule.click();

        String expectedName = "Contacts";

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedName));
    }

    @Test(invocationCount = 5)
    public void addContactTC2(){
        Faker faker = new Faker();
        //This is to make the check at the end
        String contactName = faker.name().fullName();
        //TODO:Check if there is a better way to achieve this, and understand the problem
        new HomePage().contactsModule.click();
        U.representation(represent,time);

        ContactsPage contactsPage = new ContactsPage();
        WebDriverFactory.sleep(2);

        contactsPage.newContactButton.click();
        U.representation(represent,time);
        WebDriverFactory.sleep(2);

        contactsPage.inputContactName.clear();
        contactsPage.inputContactName.sendKeys(contactName);
        U.representation(represent,time);
        WebDriverFactory.sleep(2);

        //Phone
        contactsPage.inputContactPhone.sendKeys(faker.phoneNumber().cellPhone());
        U.representation(represent,time);

        //Email
        contactsPage.inputContactEmail.sendKeys(faker.internet().emailAddress());
        U.representation(represent,time);

        //Post office box
        contactsPage.postOfficeBox.sendKeys(faker.number().numberBetween(10,100) + "");
        U.representation(represent,time);

        //Adress
        contactsPage.adress.sendKeys(faker.address().streetAddress());
        U.representation(represent,time);

        //Extended adress
        contactsPage.extendedAdress.sendKeys(faker.address().fullAddress());
        U.representation(represent,time);

        //Postalcode
        contactsPage.postalCode.sendKeys(faker.address().zipCode());
        U.representation(represent,time);

        //City
        contactsPage.city.sendKeys(faker.address().cityName());
        U.representation(represent,time);

        //State
        contactsPage.stateOrProvince.sendKeys(faker.address().state());
        U.representation(represent,time);

        //Country
        contactsPage.country.sendKeys("USA");
        U.representation(represent,time);



        boolean flag = false;

        for(WebElement element : contactsPage.contactList){
            if(element.getText().equals(contactName)){
                flag = true; } }



        Assert.assertTrue(flag); }

    @Test
    public void allContactNamesTC3(){
        HomePage homePage = new HomePage();

        homePage.contactsModule.click();
        U.representation(represent,time);

        ContactsPage contactsPage = new ContactsPage();

        for(WebElement element : contactsPage.contactList){
            System.out.println(element.getText());
        } } }
