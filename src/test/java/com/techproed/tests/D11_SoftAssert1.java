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
Yeni bir Class Olusturun : D11_SoftAssert1
1. “https://www.sahibinden.com/” Adresine gidin
2. Basliginin "Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri" oldugunu  dogrulayin
3. search kutusuna araba yazip arattirin
4. bulunan sonuc sayisini yazdirin
5. sonuc yazisinin "araba" icerdigini dogrulayin
6. Tumunu temizle linkini tiklayin
7. Bulunan sonucu yazdirin
8. Sonuc yazisinin “araba” kelimesi icermedigini dogrulayin
 */
public class D11_SoftAssert1 {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test() {
        //1. http://https://www.sahibinden.com/
        driver.get("https://sahibinden.com");

        //2. Basliginin "Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri" oldugunu  dogrulayin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle);

        //3. search kutusuna araba yazip arattirin
        String arananKelime = "araba";
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(arananKelime + Keys.ENTER);

        //4. bulunan sonuc sayisini yazdirin
        String actualSonuc = driver.findElement(By.xpath("//div[@class='result-text estimated-result-text']")).getText();
        System.out.println(actualSonuc);

        //5. sonuc yazisinin "araba" icerdigini dogrulayin
        String expectedSonuc = "araba";
        softAssert.assertTrue(actualSonuc.contains(expectedSonuc));

        //6. Tumunu temizle linkini tiklayin
        driver.findElement(By.linkText("Tümünü Temizle")).click();

        //7. Bulunan sonucu yazdirin
        String lastSonuc = driver.findElement(By.xpath("//div[@class='result-text']")).getText();
        System.out.println(lastSonuc);

        //8. Sonuc yazisinin “araba” kelimesi icermedigini dogrulayin
        String lastSonucNotExpected = "araba";
        softAssert.assertFalse(lastSonuc.contains(lastSonucNotExpected));

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
