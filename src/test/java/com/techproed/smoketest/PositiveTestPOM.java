package com.techproed.smoketest;

import com.techproed.pages.CrystalKeyHotelsPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class PositiveTestPOM extends TestBase {

    @Test
    public void test(){

        driver.get(ConfigReader.getProperty("c_url"));
        CrystalKeyHotelsPage crystalKeyHotelsPage = new CrystalKeyHotelsPage(driver);
        crystalKeyHotelsPage.logInButton.click();
        crystalKeyHotelsPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_user"));
        crystalKeyHotelsPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        crystalKeyHotelsPage.logInButton2.click();

    }
}
