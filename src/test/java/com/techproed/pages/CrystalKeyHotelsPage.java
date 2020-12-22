package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrystalKeyHotelsPage {

    WebDriver driver;

    public CrystalKeyHotelsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "(//a[@class='nav-link'])[7]")
    public WebElement logInButton;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement logInButton2;

}
