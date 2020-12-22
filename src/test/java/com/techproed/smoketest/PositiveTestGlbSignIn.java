package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTestGlbSignIn {

    @Test(groups = {"Group2", "Group3"})
    public void positiveLogInTest() {

        GlbHomePage glbHomePage = new GlbHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("url_glbl_trdr_log_in"));
        glbHomePage.emailTextBox.sendKeys(ConfigReader.getProperty("valid_email_glb"));
        glbHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password_glb"));
        glbHomePage.logInButton.click();
        Assert.assertTrue(glbHomePage.logInConfirm.isDisplayed());
        //Driver.closeDriver();


    }
}
