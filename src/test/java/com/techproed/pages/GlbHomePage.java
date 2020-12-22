package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbHomePage {

    public GlbHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(id = "password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement logInButton;

    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logInConfirm;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement logInAlert;
}
