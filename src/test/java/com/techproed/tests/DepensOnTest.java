package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
● Bir class oluşturun: DependsOnTest
● https://www.walmart.com/ adresine gidin.
  1. Test : Wallmart ana sayfaya gittiginizi test edin
  2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin  ve aramanizin gerceklestigini Test edin
  3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $6.65  oldugunu test edin
 */
public class DepensOnTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }

    @Test
    public void homePage() {
        //● https://www.walmart.com/ adresine gidin.
        driver.get("https://walmart.com");

        //1. Test : Wallmart ana sayfaya gittiginizi test edin
        WebElement logo = driver.findElement(By.className("z_a"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test(dependsOnMethods = "homePage")
    public void searchTest() {
        //2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin  ve aramanizin gerceklestigini Test edin
        WebElement searchBox = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        String arananKelime = "Nutella";
        searchBox.sendKeys(arananKelime + Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = arananKelime;
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test(dependsOnMethods = "searchTest")
    public void fiyatTesti() {
        //3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $6.65  oldugunu test edin

        //Ilk Urune tiklama
        driver.findElement(By.xpath("(//img[@data-pnodetype='item-pimg'])[1]")).click();

        //Ilk urun fiyati
        String actualPrice = driver.findElement(By.xpath("(//span[@class='price-group'])[1]")).getText();
        String expectedPrice = "$6.65";
        Assert.assertEquals(actualPrice, expectedPrice);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
