package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

/*
● Tests package’inda yeni bir class olusturun: D13_WindowHandle2
● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”  olduğunu doğrulayın.
 */
public class D13_WindowHandle2 extends TestBase {

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/windows");
        SoftAssert softAssert = new SoftAssert();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText1 = driver.findElement(By.tagName("h3")).getText();
        String expectedText1 = "Opening a new window";
        softAssert.assertEquals(actualText1, expectedText1);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        softAssert.assertEquals(actualTitle, expectedTitle);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String first = driver.getWindowHandle();
        String second = "";
        Set<String> all = driver.getWindowHandles();

        for (String w: all) {
            if(!w.equals(first)){
                second = w;
            }
        }
        driver.switchTo().window(second);

        String yeniTitle = driver.getTitle();
        String yeniBeklenenTitle = "New Window";
        softAssert.assertEquals(yeniTitle, yeniBeklenenTitle);

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        String yeniWindow = driver.findElement(By.tagName("h3")).getText();
        String expectedWindow = "New Window";
        softAssert.assertEquals(yeniWindow,expectedWindow);

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”  olduğunu doğrulayın.
        driver.switchTo().window(first);
        softAssert.assertEquals(actualTitle, expectedTitle);

        softAssert.assertAll();
    }
}
