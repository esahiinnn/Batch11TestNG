package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {

    public GlbSignUpPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement nameTextBox;

    @FindBy(xpath = "//input[@type='phone']")
    public WebElement phoneTextBox;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement ilkPassword;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement ikinciPassword;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successMesaji;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement signUpButton;


}

