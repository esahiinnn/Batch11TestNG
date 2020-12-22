package com.techproed.smoketest;

import com.techproed.pages.CrystalKeyHotelsPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class NegativeTestWithPage extends TestBase {

    @Test
    public void test(){

        driver.get("http://qa-environment.crystalkeyhotels.com");

        CrystalKeyHotelsPage crystalKeyHotels = new CrystalKeyHotelsPage(driver);
        crystalKeyHotels.logInButton.click();
        crystalKeyHotels.usernameTextBox.sendKeys("manager");
        crystalKeyHotels.passwordTextBox.sendKeys("manager");
        crystalKeyHotels.logInButton2.click();

    }
}
