package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTestGlbSignIn {

    GlbHomePage glbHomePage = new GlbHomePage();

    @Test(groups = "Group1")
    public void invalidPasswordTest() {


        Driver.getDriver().get(ConfigReader.getProperty("url_glbl_trdr_log_in"));
        glbHomePage.emailTextBox.sendKeys(ConfigReader.getProperty("valid_email_glb"));
        glbHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("invalid_password_glb"));
        glbHomePage.logInButton.click();

        Assert.assertTrue(glbHomePage.logInAlert.isDisplayed());


    }

    @Test(groups = {"Group1", "Group2"})
    public void invalidEmailTest() {

        Driver.getDriver().get(ConfigReader.getProperty("url_glbl_trdr_log_in"));
        glbHomePage.emailTextBox.sendKeys(ConfigReader.getProperty("invalid_email_glb"));
        glbHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password_glb"));
        glbHomePage.logInButton.click();

        Assert.assertTrue(glbHomePage.logInAlert.isDisplayed());

    }

    @Test(groups = {"Group1", "Group2", "Group3"})
    public void bothInvalidTest(){
        Driver.getDriver().get(ConfigReader.getProperty("url_glbl_trdr_log_in"));

        glbHomePage.emailTextBox.sendKeys(ConfigReader.getProperty("invalid_email_glb"));
        glbHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("invalid_password_glb"));
        glbHomePage.logInButton.click();

        Assert.assertTrue(glbHomePage.logInAlert.isDisplayed());


    }
}
