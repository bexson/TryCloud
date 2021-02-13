package com.trycloud.fatih.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ContactsPage {


    public ContactsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "new-contact-button")
    public WebElement newContactButton;

    @FindBy(id = "contact-fullname")
    public WebElement inputContactName;

    @FindBy(xpath = "//input[@inputmode='tel']")
    public WebElement inputContactPhone;

    @FindBy(xpath = "//input[@inputmode='email']")
    public WebElement inputContactEmail;

    @FindBy(xpath = "//div[@prop-name='adr']/div[2]/input")
    public WebElement postOfficeBox;

    @FindBy(xpath = "//div[@prop-name='adr']/div[3]/input")
    public  WebElement adress;

    @FindBy(xpath = "//div[@prop-name='adr']/div[4]/input")
    public WebElement extendedAdress;

    @FindBy(xpath = "//div[@prop-name='adr']/div[5]/input")
    public WebElement postalCode;

    @FindBy(xpath = "//div[@prop-name='adr']/div[6]/input")
    public WebElement city;

    @FindBy(xpath = "//div[@prop-name='adr']/div[7]/input")
    public WebElement stateOrProvince;

    @FindBy(xpath = "//div[@prop-name='adr']/div[8]/input")
    public WebElement country;

    @FindBy(xpath = "//div[@class='app-content-list-item-line-one']")
    public List<WebElement> contactList;


    public void moduleTitleCheck(){
        String expectedName = "Contacts";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedName));
    }



}
