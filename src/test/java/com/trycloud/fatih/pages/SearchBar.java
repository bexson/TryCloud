package com.trycloud.fatih.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBar {

    public SearchBar(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//a[@class='header-menu__trigger']")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;


}
