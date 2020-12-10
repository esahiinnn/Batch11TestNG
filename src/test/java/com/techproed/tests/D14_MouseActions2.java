package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
Yeni bir class olusturalim: D14_MouseActions2
1- http://uitestpractice.com/Students/Actions adresine gidelim
 2- Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini  gorelim
 3- Click Me butonuna click yapalim ve cikan alertteki mesajin  "Clicked !!" oldugunu dogrulayalim
 4- Double Click Me! butonuna tiklayalim ve cikan mesajin "Double  Clicked !!" oldugunu dogrulayalim
 5- Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
 */
public class D14_MouseActions2 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        //1- http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

        //2- Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini  gorelim
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='div2']"))).perform();
        Thread.sleep(3000);

        //3- Click Me butonuna click yapalim ve cikan alertteki mesajin  "Clicked !!" oldugunu dogrulayalim
        actions.click(driver.findElement(By.xpath("//button[@name='click']"))).perform();
        Thread.sleep(3000);
        String firstMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        softAssert.assertEquals(firstMessage, "Clicked !!");


        //4- Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        actions.doubleClick(driver.findElement(By.xpath("//button[@name='dblClick']"))).perform();
        Thread.sleep(3000);
        String secondMessage = driver.switchTo().alert().getText();
        softAssert.assertEquals(secondMessage, "Double Clicked !!");
        driver.switchTo().alert().accept();


        //5- Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(draggable, droppable).perform();
        Thread.sleep(3000);
        String dbClicked = droppable.getText();
        softAssert.assertEquals(dbClicked, "Dropped!");


        softAssert.assertAll();
    }
}
