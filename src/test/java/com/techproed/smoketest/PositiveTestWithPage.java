package com.techproed.smoketest;

import com.techproed.pages.CrystalKeyHotelsPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

//1) com.techproed altinda bir package olustur : smoketest
//2) Bir Class olustur : PositiveTest
//3) Bir test method olustur positiveLoginTest()
//     http://qa-environment.crystalkeyhotels.com adresine git
//    login butonuna bas
//test data username: manager ,
//test data password : Manager2!
//Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
public class PositiveTestWithPage extends TestBase {

    @Test
    public void test(){
        ////     http://qa-environment.crystalkeyhotels.com adresine git
        driver.get("http://qa-environment.crystalkeyhotels.com");

        CrystalKeyHotelsPage positiveTestCRYSTAL = new CrystalKeyHotelsPage(driver);

        positiveTestCRYSTAL.logInButton.click();
        positiveTestCRYSTAL.usernameTextBox.sendKeys("manager");
        positiveTestCRYSTAL.passwordTextBox.sendKeys("Manager2!");
        positiveTestCRYSTAL.logInButton2.click();

    }
}
