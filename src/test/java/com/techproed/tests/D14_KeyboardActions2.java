package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
1- Bir Class olusturalim D14_KeyboardActions1
2- https://www.facebook.com sayfasina gidelim
3- Kullanici adi : Mehmet , sifre : 12345 degerlerini girip login tusuna basalim
4- basarili login olmadigini test edin
 */
public class D14_KeyboardActions2 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        Actions actions = new Actions(driver);
        //2- https://www.facebook.com sayfasina gidelim
        driver.get("https://facebook.com");

//3- Kullanici adi : Mehmet , sifre : 12345 degerlerini girip login tusuna basalim
        actions.
                click(driver.findElement(By.xpath("//input[@type='text']"))).
                keyDown(Keys.SHIFT).
                sendKeys("m").
                keyUp(Keys.SHIFT).
                sendKeys("ehmet").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("12345").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        //4- basarili login olmadigini test edin
        Thread.sleep(5000);
        WebElement logIn = driver.findElement(By.xpath("//button[@value='1']"));
        Assert.assertTrue(logIn.isDisplayed());
    }

}
