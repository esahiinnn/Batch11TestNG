package com.techproed.smoketest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
1) com.techproed altinda bir package olustur : smoketest
2) Bir Class olustur : PositiveTest
3) Bir test method olustur positiveLoginTest()
   http://qa-environment.crystalkeyhotels.com adresine git
  login butonuna bas
test data username: manager ,
test data password : Manager2!
Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
 */
public class PositiveTest extends TestBase {

    @Test
    public void positiveLoginTest() {

        driver.get("http://qa-environment.crystalkeyhotels.com");

        //Log-in butonuna basin
        driver.findElement(By.xpath("(//a[@class='nav-link'])[7]")).click();

        //username textbox'ina valid username girin, password girin log'in e basin
        Actions actions = new Actions(driver);
        actions.
                click(driver.findElement(By.xpath("//input[@type='text']"))).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager2!").
                sendKeys(Keys.ENTER).
                perform();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Admin";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
