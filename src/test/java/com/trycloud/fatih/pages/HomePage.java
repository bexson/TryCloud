package com.trycloud.fatih.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']/li/a/span")
    public List<WebElement> moduleNames;


    @FindBy(xpath = "//ul[@id='appmenu']/li[2]")
    public WebElement filesModule;
}
