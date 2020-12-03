package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
● https://www.amazon.com/ adresine gidin.
  - Test 1
  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin  45 oldugunu test edin
  -Test 2
 1. Kategori menusunden Books secenegini  secin
 2. Arama kutusuna Java yazin ve aratin
 3. Bulunan sonuc sayisini yazdirin
  4. Sonucun Java kelimesini icerdigini test edin
 */
public class D10_DropDownAmazon {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

    }

    @Test
    public void test1(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin  45 oldugunu test edin
        Select kategoriMenusu = new Select(driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']")));
        List<WebElement> allOptions = kategoriMenusu.getOptions();
        int kategoriSize = allOptions.size()-1;
        Assert.assertEquals(kategoriSize, 45);

    }

    @Test
    public void test2(){
        //1. Kategori menusunden Books secenegini  secin
        Select kategoriMenusu = new Select(driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']")));
        kategoriMenusu.selectByVisibleText("Books");

        //2. Arama kutusuna Java yazin ve aratin
        String aranicakKelime = "Java";
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(aranicakKelime + Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucSayisi.getText());

        //4. Sonucun Java kelimesini icerdigini test edin
        WebElement sonucIcerme = driver.findElement(By.xpath("(//span[@dir='auto'])[3]"));
        String actualSonuc = sonucIcerme.getText();
        String expectedSonuc = "Java";
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));


    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
