package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
Yeni bir Class Olusturun : D10_SoftAssert2
1. “http://zero.webappsecurity.com/” Adresine gidin
 2. Sign in butonuna basin
 3. Login kutusuna “username” yazin
 4. Password kutusuna “password.” yazin
 5. Sign in tusuna basin
 6. Pay Bills sayfasina gidin
 7. “Purchase Foreign Currency” tusuna basin
 8. “Currency” drop down menusunden Eurozone’u secin
 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One",
 "Australia (dollar)",
 "Canada (dollar)",
 "Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
 */
public class D11_SoftAssert2 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void test() {
        SoftAssert softAssert = new SoftAssert();

        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

        //3. Login kutusuna “username” yazin
        String arananUserName = "username";
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(arananUserName);

        //4. Password kutusuna “password” yazin
        String arananPw = "password";
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(arananPw);

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='pc_currency']")));
        dropDown.selectByValue("EUR");

        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        String actualFirst = dropDown.getFirstSelectedOption().getText();
        String expectedFirst = "Eurozone (Euro)";
        softAssert.assertEquals(actualFirst, expectedFirst, "Eurozone (Euro) secilmemistir");

        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One",....
        List<WebElement> allList = dropDown.getOptions();
        List<String> allListToString = new ArrayList<String>();
        for (WebElement w : allList) {
            allListToString.add(w.getText());
        }
        List<String> expecTedString = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)", "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)");

        softAssert.assertEquals(allListToString, expecTedString, "Listler ayni degildir");
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        //driver.close();
    }
}
