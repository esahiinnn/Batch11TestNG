package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/*
● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
● Bir metod olusturun: acceptAlert
 ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfuly clicked an alert” oldugunu test edin.
● Bir metod olusturun: dismissAlert
 ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının  “successfuly” icermedigini test edin.
● Bir metod olusturun: sendKeysAlert
 ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
 */
public class D12_Alerts {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    //● Bir metod olusturun: acceptAlert
    @Test
    public void acceptAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfuly clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "You successfuly clicked an alerts";
        Assert.assertEquals(actualResult, expectedResult);

    }

    //● Bir metod olusturun: dismissAlert
    @Test
    public void dismissAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının  “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "successfuly";
        Assert.assertFalse(actualResult.contains(expectedResult));
    }

    //● Bir metod olusturun: sendKeysAlert
    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(3000);

        driver.switchTo().alert().sendKeys("Ebubekir");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String actualWord = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(actualWord.contains("Ebubekir"));

    }

    @AfterClass
    public void tearDown() {
        //driver.close();
    }
}