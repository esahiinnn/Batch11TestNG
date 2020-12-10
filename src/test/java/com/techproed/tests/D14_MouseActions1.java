package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

/*
1- Yeni bir class olusturalim: D14_MouseActions1
2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
3- Cizili alan uzerinde sag click yapalim
4- Alert’te cikan yazinin “You selected a context menu” oldugunu
   test edelim.
5- Tamam diyerek alert’I kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
 */
public class D14_MouseActions1 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement contextMenu = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.moveToElement(contextMenu).contextClick().perform();
        Thread.sleep(5000);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String uyariMesaji = driver.switchTo().alert().getText();
        Assert.assertEquals(uyariMesaji, "You selected a context menu");

        //5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[@target='_blank']"));
        actions.click(elementalSelenium).perform();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String firstWindowHandle = driver.getWindowHandle();
        String secondWindowHandle = "";
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String w: allWindowHandles) {
            if(!w.equals(firstWindowHandle)){
                secondWindowHandle = w;
            }
        }

        driver.switchTo().window(secondWindowHandle);
        String seleniumText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(seleniumText, "Elemental Selenium");
    }
}
