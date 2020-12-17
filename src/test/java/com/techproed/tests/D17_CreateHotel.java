package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
1. Tests packagenin altına class olusturun: CreateHotel
2. Bir metod olusturun: createHotel
3. qa-environment.crystalkeyhotels.com adresine git.
4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri  girin.
 a. Username : manager
 b. Password : Manager2!
5. Login butonuna tıklayın.
6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
8. Save butonuna tıklayın.
9. “Hotel was inserted successfully” textinin göründüğünü test edin.
10. OK butonuna tıklayın.
 */
public class D17_CreateHotel extends TestBase {

    @Test
    public void createHotel() throws InterruptedException {
        String username = "manager";
        String password = "Manager2!";

        //3. qa-environment.crystalkeyhotels.com adresine git.
        driver.get("http://qa-environment.crystalkeyhotels.com");

        //Log-in butonuna basin
        driver.findElement(By.xpath("(//a[@class='nav-link'])[7]")).click();

        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri  girin.

        WebElement usernameTextBox = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@name='Password']"));

        // a. Username : manager
        usernameTextBox.sendKeys(username);

        // b. Password : Manager2!
        //5. Login butonuna tıklayın.
        passwordTextBox.sendKeys(password + Keys.ENTER);

        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='icon-list']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menuHotels']")).click();
        driver.findElement(By.xpath("(//i[@class='icon-calendar'])[2]")).click();
        driver.findElement(By.xpath("//span[@class='hidden-480']")).click();

        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.
                click(driver.findElement(By.xpath("//input[@id='Code']"))).
                sendKeys("1234").
                sendKeys(Keys.TAB).
                sendKeys("Hilton").
                sendKeys(Keys.TAB).
                sendKeys("Turkiye").
                sendKeys(Keys.TAB).sendKeys("05478451245").sendKeys(Keys.TAB).sendKeys("hiltonhotels@gmail.com").perform();

        Select select = new Select(driver.findElement(By.xpath("//select[@name='IDGroup']")));
        select.selectByVisibleText("Hotel Type2");

        ////8. Save butonuna tıklayın.
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        WebElement succcessfulMessage = driver.findElement(By.xpath("//div[@class='bootbox-body']"));
        Assert.assertTrue(succcessfulMessage.isDisplayed());

        //10. OK butonuna tıklayın.
        driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
    }
}
